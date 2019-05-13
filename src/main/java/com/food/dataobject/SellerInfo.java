package com.food.dataobject;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**卖家信息
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-13 10:02
 */
@Data
@Entity
public class SellerInfo {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
