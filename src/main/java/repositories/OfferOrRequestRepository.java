package repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.OfferOrRequest;

@Repository
public interface OfferOrRequestRepository extends JpaRepository<OfferOrRequest,Integer> {
	//Ratio of offers versus requests.
	@Query("select count(o)-(select count(o1) from OfferOrRequest o1 where o.isOffer=false) from OfferOrRequest o where o.isOffer=true")
	public Double getRatio();
	//Average number of offers and request per customer.
	@Query("select count(o)*1.0/(select count(c) from Customer c) from OfferOrRequest o")
	public Double getAveragePerCustomer();
	//Average number of applications per offer or request.
	@Query("select count(a)/count(o) from OfferOrRequest o join o.applications a")
	public Double getAverageApplicationsPerOfferOrRequest();
}
