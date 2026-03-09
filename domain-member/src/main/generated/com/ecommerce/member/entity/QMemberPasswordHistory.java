package com.ecommerce.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberPasswordHistory is a Querydsl query type for MemberPasswordHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberPasswordHistory extends EntityPathBase<MemberPasswordHistory> {

    private static final long serialVersionUID = -916346867L;

    public static final QMemberPasswordHistory memberPasswordHistory = new QMemberPasswordHistory("memberPasswordHistory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath password = createString("password");

    public QMemberPasswordHistory(String variable) {
        super(MemberPasswordHistory.class, forVariable(variable));
    }

    public QMemberPasswordHistory(Path<? extends MemberPasswordHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberPasswordHistory(PathMetadata metadata) {
        super(MemberPasswordHistory.class, metadata);
    }

}

