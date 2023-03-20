package hu.markmuhari.movies.repository;

import hu.markmuhari.movies.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.rmi.server.ObjID;
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjID> {
}
