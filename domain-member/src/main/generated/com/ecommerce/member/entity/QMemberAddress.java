package com.ecommerce.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberAddress is a Querydsl query type for MemberAddress
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberAddress extends EntityPathBase<MemberAddress> {

    private static final long serialVersionUID = 358050440L;

    public static final QMemberAddress memberAddress = new QMemberAddress("memberAddress");

    public final StringPath address = createString("address");

    public final StringPath addressDetail = createString("addressDetail");

    public final StringPath addressName = createString("addressName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isDefault = createBoolean("isDefault");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath receiverName = createString("receiverName");

    public final StringPath receiverPhone = createString("receiverPhone");

    public final StringPath zipCode = createString("zipCode");

    public QMemberAddress(String variable) {
        super(MemberAddress.class, forVariable(variable));
    }

    public QMemberAddress(Path<? extends MemberAddress> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberAddress(PathMetadata metadata) {
        super(MemberAddress.class, metadata);
    }

}

