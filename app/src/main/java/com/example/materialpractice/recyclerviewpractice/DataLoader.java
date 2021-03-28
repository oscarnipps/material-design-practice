package com.example.materialpractice.recyclerviewpractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* loads data to the corresponding adapters
*/
public class DataLoader {

    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"baked bread","200",0,0,0));
        products.add(new Product(2,"fresh mint","100",0,0,0));
        products.add(new Product(3,"butter","1000",0,0,0));
        products.add(new Product(4,"stew dumps","550",0,0,0));
        products.add(new Product(5,"beans leaves","650",0,0,0));
        products.add(new Product(6,"stems","890",0,0,0));
        products.add(new Product(7,"diamond jelly","1200",0,0,0));
        products.add(new Product(8,"rice mix","400",0,0,0));
        products.add(new Product(9,"weetabix","300",0,0,0));
        products.add(new Product(10,"kellogs","150",0,0,0));
        products.add(new Product(11,"dan flakes","270",0,0,0));
        products.add(new Product(12,"purple jello","4600",0,0,0));
        products.add(new Product(13,"plug outlets","820",0,0,0));
        products.add(new Product(14,"chocolate bars","690",0,0,0));
        products.add(new Product(15,"sneakers","390",0,0,0));
        products.add(new Product(16,"bounty","210",0,0,0));
        products.add(new Product(17,"winners bread","310",0,0,0));
        products.add(new Product(18,"paracetamol","100",0,0,0));
        products.add(new Product(19,"golddilocks","710",0,0,0));
        products.add(new Product(20,"bic pen","920",0,0,0));
        products.add(new Product(21,"onward paper","510",0,0,0));
        products.add(new Product(22,"caprisome","80",0,0,0));
        products.add(new Product(23,"lantern","330",0,0,0));
        products.add(new Product(24,"coco pops","480",0,0,0));
        return products;
    }

    public static Map<Integer,Product> getAddedProducts(int ... indexes) {
        Map<Integer,Product> addedProducts = new HashMap<>();

        List<Product> items =  getProducts();

        for (int index : indexes) {

            Product product =  items.get(index);

            product.setFacing(100);

            product.setCases(20);

            addedProducts.put(product.getId(), product);
        }

        return addedProducts;
    }
}
