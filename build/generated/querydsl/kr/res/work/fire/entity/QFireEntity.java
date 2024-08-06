package kr.res.work.fire.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFireEntity is a Querydsl query type for FireEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFireEntity extends EntityPathBase<FireEntity> {

    private static final long serialVersionUID = -1668629068L;

    public static final QFireEntity fireEntity = new QFireEntity("fireEntity");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public QFireEntity(String variable) {
        super(FireEntity.class, forVariable(variable));
    }

    public QFireEntity(Path<? extends FireEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFireEntity(PathMetadata metadata) {
        super(FireEntity.class, metadata);
    }

}

