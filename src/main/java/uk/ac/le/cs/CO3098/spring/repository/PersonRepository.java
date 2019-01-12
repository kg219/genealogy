package uk.ac.le.cs.CO3098.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uk.ac.le.cs.CO3098.spring.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {
	
@Query(value= "SELECT * FROM Person WHERE perso_key = :id" , nativeQuery = true)
List<Person> findKey(@Param("id") int id);
@Query(value= "SELECT * FROM Person WHERE perso_key = :id" , nativeQuery = true)
List<Person> findKey(@Param("id") Object id);
@Query(value= "SELECT Mother_key FROM Person WHERE perso_key = :id" , nativeQuery = true)
List<Person> findMother(@Param("id") int id);
@Query(value= "SELECT Father_key FROM Person WHERE perso_key = :id" , nativeQuery = true)
List<Person> findFather(@Param("id") int id);
@Query(value= "SELECT * FROM Person WHERE Mother_key = :mid" , nativeQuery = true)
List<Person> findMotherKey(@Param("mid") Object mid);
@Query(value= "SELECT * FROM Person WHERE Father_key = :fid" , nativeQuery = true)
List<Person> findFatherKey(@Param("fid") Object fid);

@Modifying(clearAutomatically = true)
@Transactional
@Query(value= "DELETE * FROM Person WHERE perso_key = :key" , nativeQuery = true)
void deletePerson(@Param("key") Object key);

@Modifying(clearAutomatically = true)
@Transactional
@Query(value= "UPDATE Person SET perso_key =:key, Fullname =:name, dob=: dob, Mother_key =: motherKey, Father_key := fatherKey, gender := gender WHERE perso_key =:key" , nativeQuery = true)
void edit(@Param("key") Object key,@Param("name") Object name, @Param("dob") Object dob, @Param("motherKey") Object motherKey, @Param("fatherKey") Object fatherKey, @Param("gender") String gender);


}
