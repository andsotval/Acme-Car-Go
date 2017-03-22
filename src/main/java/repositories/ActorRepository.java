package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
	// Average number of comments per actor, offer, or request.
	@Query("select ((avg(a.comments.size)+(select avg(o.comments.size) from OfferOrRequest o))/2) from Actor a")
	public Double getActorsAverageCommentsAll();
	// Average number of comments posted by administrators and customers.
	@Query("select avg(a.comments.size) from Actor a")
	public Double getActorsAverageComments();
	// The actors who have posted ±10% the average number of comments per actor.
	@Query("select a from Actor a where a.comments.size between ((select avg(a.comments.size) from Actor a)-((select avg(a.comments.size) from Actor a)*0.1)) and ((select avg(a.comments.size) from Actor a)+((select avg(a.comments.size) from Actor a)*0.1))")
	public Collection<Actor> getActorsMoreCommentsByAverage();
}
