package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Customer;
import security.UserAccount;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	//The customer who has more applications accepted.
	@Query("select n from Customer n where ((select count(t2) from Customer n2 join n2.applications t2 where t2.application=1 AND n2.id=n.id)>=all(select count(t3) from Customer n3 join n3.applications t3 where t3.application=1 group by n3)) group by n")
	public Customer getCustomerMoreApplicationsAccepted();
	//The customer who has more applications denied.
	@Query("select n from Customer n where ((select count(t2) from Customer n2 join n2.applications t2 where t2.application=2 AND n2.id=n.id)>=all(select count(t3) from Customer n3 join n3.applications t3 where t3.application=2 group by n3)) group by n")
	public Customer getCustomerMoreApplicationsDenied();
	//Find by UserAccount
    @Query("select n from Customer n where n.userAccount = ?1")
    public Customer findByUserAccount(UserAccount userAccount);

}
