package network.repository.user;

import network.entity.User;
import network.entity.UserAvgAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return mongoTemplate.insert(user);
    }

    @Override
    public double getAvgAge() {
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.group().avg("age").as("avgAge"));
        AggregationResults aggregationResults = mongoTemplate.aggregate(agg, "users", UserAvgAge.class);
        List<UserAvgAge> results = aggregationResults.getMappedResults();
        if (results.isEmpty())
            return 0;
        return results.get(0).getAvgAge();
    }
}
