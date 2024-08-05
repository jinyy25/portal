package kr.res.work.fire.repository;



import kr.res.work.fire.entity.FireEntity;
import kr.res.work.fire.repository.querydsl.FireRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FireSearchRepository extends JpaRepository<FireEntity, Long>, QuerydslPredicateExecutor<FireEntity>, FireRepositoryCustom {

}
