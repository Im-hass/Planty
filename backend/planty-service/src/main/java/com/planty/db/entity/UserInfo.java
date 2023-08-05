package com.planty.db.entity;

import com.planty.common.enums.UserType;
import com.planty.db.entity.common.BaseEntity;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Table(name = "user_info")
@Entity
public class UserInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL의 AUTO_INCREMENT를 사용
    @Column(name = "uid")
    private Long uid;

//    @Column(unique = true, nullable = false)
//    private String oAuth2Id;

    @Column(name = "nickname", length = 16, nullable = false)
    private String id;

    @Column(name = "email", length = 64, unique = true, nullable = false)
    private String email;

    @Column(name = "auth", length = 1024, nullable = true)
    private String auth;

    @Column(name = "photo", length = 256, nullable = true)
    private String photo;

//    @Column(name = "join_time")
////    @CreationTimestamp
//    @CreatedDate
//    private String joinTime;

    @Column(name = "emergency_count")
    @ColumnDefault("1")
    private Integer emergencyCount;

    @Column(name = "shipping_address", length = 256, nullable = true)
    private String shippingAddress;

    @Column(columnDefinition = "ENUM('KAKAO', 'NAVER', 'FACEBOOK', 'GOOGLE', 'PAYCO', 'NORMAL') DEFAULT 'NORMAL'")
    @Enumerated(EnumType.STRING)
    private UserType userType;

//    public UserInfo update(OAuth2UserInfo oAuth2UserInfo) {
//        this.nickname = oAuth2UserInfo.getNickname();
//        this.auth = oAuth2UserInfo.getOAuth2Id();
//
//        return this;
//    }

//    /* 회원정보 수정을 위한 set method*/
//    public void modify(String nickname) {
//        this.nickname = nickname;
//    }
//
//    /* 소셜로그인시 이미 등록된 회원이라면 수정날짜만 업데이트하고
//     * 기존 데이터는 그대로 보존하도록 예외처리 */
//    public UserInfo updateModifiedDate() {
//        this.onPreUpdate();
//        return this;
//    }


//    @Transient -> @Column과 반대로 테이블에 컬럼으로 생성되지 않는 필드의 경우엔 @Transient 어노테이션을 적용
}