package com.spring.mvcproject.chap2_3.controller;

import com.spring.mvcproject.chap2_3.entity.Product;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {

    //가상의 메모리 상품 저장소
    private Map<Long, Product> productStore = new HashMap<>();

    public ProductController(){
        productStore.put(1L, new Product(1L, "에어컨", 1000000));
        productStore.put(2L, new Product(2L, "세탁기", 1500000));
        productStore.put(3L, new Product(3L, "공기청정기", 200000));
    }

    // 상품 조회: GET
//    @GetMapping("/products")
//    public String getProduct(HttpServletRequest req){
//        String id = req.getParameter("id");
//        String price = req.getParameter("price");
//
//        System.out.printf("/products?id%s : GET 요청이 들어옴!%n".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";

    // /products?id=8&price=12000

//    @GetMapping("/products")
//    public String getProduct(
//            Long id,     //requestparam 안의 변수는 임의로 변경하면 안되지만 뒤에는 가능
//            int price
//    ){
//
//
//
//        System.out.printf("/products?id%s : GET 요청이 들어옴!%n".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//
//    }


//@GetMapping("/products")
//public String getProduct(
//        Long id,     //requestparam 안의 변수는 임의로 변경하면 안되지만 뒤에는 가능
//        @RequestParam(required = false ,defaultValue = "1000") int price   //필수가 아닌 경우
//){
//
//
//
//    System.out.printf("/products?id%s : GET 요청이 들어옴!%n".formatted(id));
//    System.out.println("id = " + id);
//    System.out.println("price = " + price);
//    return "";
//
//}



    @GetMapping("/products/{id}")
    @ResponseBody //JSON 응답
    public Product getProduct(
            @PathVariable Long id

    ){
        System.out.printf("/products/%s : GET 요청이 들어옴!%n".formatted(id));
        System.out.println("id = " + id);

        Product product = productStore.get(id);

        return product;

    }
}
