package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name="Member")
@SequenceGenerator(
        name="MEMBER_SEQ_GENERATOR",
        sequenceName="MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 50
)

public class Member{

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private long id;
    @Column(name = "USERNAME")
    private String username;


    @Embedded
    //기간
     private Period workPeriod;
    @Embedded
    //주소
     private Address homeAddress;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
                         @AttributeOverride(name = "street", column = @Column(name ="WORK_STREET")),
                         @AttributeOverride(name = "zipcode", column = @Column(name ="WORK_ZIPCODE"))
    })
    private Address workAddress;

    public Member() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
