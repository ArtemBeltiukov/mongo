package network.repository.message;

import network.entity.Message;
import network.entity.MessagesCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MessageRepositoryCustomImpl implements MessageRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Message createMessage(Message message) {
        return mongoTemplate.insert(message);
    }

    @Override
    public MessagesCount getUserWithMaxMessages() {
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.group("from").count().as("total"),
                Aggregation.sort(Sort.Direction.DESC, "total"));
        AggregationResults aggregationResults = mongoTemplate.aggregate(agg, "messages", MessagesCount.class);
        List<MessagesCount> result = aggregationResults.getMappedResults();
        if (result.isEmpty())
            return null;
        return result.get(0);
    }
}
