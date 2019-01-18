package cn.miswang.aigou.service.impl;

import cn.miswang.aigou.ProductService_8002;
import cn.miswang.aigou.domain.Product;
import cn.miswang.aigou.query.ProductQuery;
import cn.miswang.aigou.util.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductService_8002.class )
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void selectPageList() {
        PageList<Product> page = productService.selectPageList(new ProductQuery());
        System.out.println(page.getTotal());
        for (Product product : page.getRows()) {
            System.out.println(product);
            System.out.println(product.getProductType());
            System.out.println(product.getBrand());
            System.out.println(product.getProductExt());
        }
    }
}