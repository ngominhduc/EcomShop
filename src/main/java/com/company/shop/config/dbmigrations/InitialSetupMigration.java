package com.company.shop.config.dbmigrations;

import com.company.shop.domain.Authority;
import com.company.shop.domain.Category;
import com.company.shop.domain.Comments;
import com.company.shop.domain.Product;
import com.company.shop.domain.User;
import com.company.shop.security.AuthoritiesConstants;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.Instant;
import java.util.ArrayList;

/**
 * Creates the initial database setup.
 */
@ChangeLog(order = "001")
public class InitialSetupMigration {

    @ChangeSet(order = "01", author = "initiator", id = "01-addAuthorities")
    public void addAuthorities(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);
        mongoTemplate.save(adminAuthority);
        mongoTemplate.save(userAuthority);
    }

    @ChangeSet(order = "02", author = "initiator", id = "02-addUsers")
    public void addUsers(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);

        User systemUser = new User();
        systemUser.setId("user-0");
        systemUser.setLogin("system");
        systemUser.setPassword("$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG");
        systemUser.setFirstName("");
        systemUser.setLastName("System");
        systemUser.setEmail("system@localhost");
        systemUser.setActivated(true);
        systemUser.setLangKey("en");
        systemUser.setCreatedBy(systemUser.getLogin());
        systemUser.setCreatedDate(Instant.now());
        systemUser.getAuthorities().add(adminAuthority);
        systemUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(systemUser);

        User anonymousUser = new User();
        anonymousUser.setId("user-1");
        anonymousUser.setLogin("anonymoususer");
        anonymousUser.setPassword("$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO");
        anonymousUser.setFirstName("Anonymous");
        anonymousUser.setLastName("User");
        anonymousUser.setEmail("anonymous@localhost");
        anonymousUser.setActivated(true);
        anonymousUser.setLangKey("en");
        anonymousUser.setCreatedBy(systemUser.getLogin());
        anonymousUser.setCreatedDate(Instant.now());
        mongoTemplate.save(anonymousUser);

        User adminUser = new User();
        adminUser.setId("user-2");
        adminUser.setLogin("admin");
        adminUser.setPassword("$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC");
        adminUser.setFirstName("admin");
        adminUser.setLastName("Administrator");
        adminUser.setEmail("admin@localhost");
        adminUser.setActivated(true);
        adminUser.setLangKey("en");
        adminUser.setCreatedBy(systemUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);

        User userUser = new User();
        userUser.setId("user-3");
        userUser.setLogin("user");
        userUser.setPassword("$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K");
        userUser.setFirstName("");
        userUser.setLastName("User");
        userUser.setEmail("user@localhost");
        userUser.setActivated(true);
        userUser.setLangKey("en");
        userUser.setCreatedBy(systemUser.getLogin());
        userUser.setCreatedDate(Instant.now());
        userUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(userUser);
    }

    @ChangeSet(order = "03", author = "initiator", id = "03-addCategory")
    public void addCategory(MongoTemplate mongoTemplate){
        Category c1 = new Category();
        c1.setName("Andoird");
        mongoTemplate.save(c1);

        Category c2 = new Category();
        c2.setName("IOS");
        mongoTemplate.save(c2);

        Category c3 = new Category();
        c3.setName("Laptop");
        mongoTemplate.save(c3);
    }

    @ChangeSet(order = "04", author = "initiator", id = "04-addProduct")
    public void addProduct(MongoTemplate mongoTemplate){

        User adminUser = mongoTemplate.findById("user-2", User.class);
        String date = "03-09-2020;14:14:14";
        ArrayList<Comments> comments1 = new ArrayList<>();
        ArrayList<Comments> comments2 = new ArrayList<>();

        Comments comment1 = new Comments();
        comment1.setTitle("test comment 1");
        comment1.setBody("test body comment 1");
        comment1.setNote(9);
        comment1.setDate(date);
        comment1.setUser(adminUser);
        
        Comments comment2 = new Comments();
        comment2.setTitle("test comment 2");
        comment2.setBody("test body comment 2");
        comment2.setNote(9);
        comment2.setDate(date);
        comment2.setUser(adminUser);

        Comments comment3 = new Comments();
        comment3.setTitle("test comment 3");
        comment3.setBody("test body comment 3");
        comment3.setNote(9);
        comment3.setDate(date);
        comment3.setUser(adminUser);

        comments1.add(comment1);
        comments1.add(comment2);
        comments1.add(comment3);

        comments2.add(comment2);
        comments2.add(comment3);

        Product p1 = new Product();
        p1.setName("ROG 2");
        p1.description("gaming phone");
        p1.setQuantity(20);
        p1.setPrice(400);
        p1.setComments(comments1);
        mongoTemplate.save(p1);

        Product p2 = new Product();
        p2.setName("Iphone 11");
        p2.description("iphone");
        p2.setQuantity(20);
        p2.setPrice(400);
        p2.setComments(comments2);
        mongoTemplate.save(p2);

        Product p3 = new Product();
        p3.setName("Asus ROG GL552 vx");
        p3.description("laptop");
        p3.setQuantity(20);
        p3.setPrice(400);
        p3.setComments(comments1);
        mongoTemplate.save(p3);

        Product p4 = new Product();
        p4.setName("DELL XPS");
        p4.description(" CPU: Intel Core i7-8565U | GPU: Intel UHD 620 | RAM: 16GB");
        p4.setQuantity(20);
        p4.setPrice(400);
        p4.setComments(comments2);
        mongoTemplate.save(p4);

        Product p5 = new Product();
        p5.setName("Acer Aspire 5");
        p5.description("  CPU: Intel Core i3-8145U | GPU: Intel UHD 620 | RAM: 4GB");
        p5.setQuantity(20);
        p5.setPrice(400);
        p5.setComments(comments1);
        mongoTemplate.save(p5);
    }
}
