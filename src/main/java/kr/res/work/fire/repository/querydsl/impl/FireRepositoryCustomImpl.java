package kr.res.work.fire.repository.querydsl.impl;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.res.work.fire.dto.FireRequestDto;
import kr.res.work.fire.dto.FireResponseDto;
import kr.res.work.fire.repository.querydsl.FireRepositoryCustom;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static kr.res.work.fire.entity.QFireEntity.fireEntity;


@RequiredArgsConstructor
public class FireRepositoryCustomImpl implements FireRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;

    private final JPAQueryFactory queryFactory;

    public List<FireResponseDto> getInfoList(FireRequestDto fireRequestDto) {


        List<FireResponseDto> res = queryFactory
                .select(Projections.constructor(FireResponseDto.class,
                        fireEntity.id,
                        fireEntity.title,
                        fireEntity.content
                ))
                 .from(fireEntity)
                .orderBy(fireEntity.id.asc())
                .fetch();



        return res;
    }



}
