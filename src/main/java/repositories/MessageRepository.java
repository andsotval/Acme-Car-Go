package repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Actor;
import domain.MessageActor;

@Repository
public interface MessageRepository extends JpaRepository<MessageActor,Integer> {
	//The minimum, the average, and the maximum number of messages sent per actor.
	@Query("select min(a.senders.size),avg(a.senders.size),max(a.senders.size) from Actor a")
	public Double[] getMessageStatsSent();
	//The minimum, the average, and the maximum number of messages received per actor.
	@Query("select min(a.receivers.size),avg(a.receivers.size),max(a.receivers.size) from Actor a")
	public Double[] getMessageStatsReceived();
	//The actors who have sent more messages.
	@Query("select n from Actor n where ((select count(t2) from Actor n2 join n2.senders t2 where n2.id=n.id)>=all(select count(t3) from Actor n3 join n3.senders t3 group by n3)) group by n")
	public Actor getActorMoreSent();
	//The actors who have got more messages.
	@Query("select n from Actor n where ((select count(t2) from Actor n2 join n2.receivers t2 where n2.id=n.id)>=all(select count(t3) from Actor n3 join n3.receivers t3 group by n3)) group by n")
	public Actor getActorMoreReceived();
}
