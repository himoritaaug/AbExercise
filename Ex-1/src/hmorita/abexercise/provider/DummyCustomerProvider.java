package hmorita.abexercise.provider;

import hmorita.abexercise.entity.Customer;

public class DummyCustomerProvider implements DataProvider<Customer> {
    @Override
    public Customer[] provide() {
        return new Customer[]{
                new Customer(7602,"角田 三郎"),
                new Customer(7603,"柴咲 里奈"),
                new Customer(7604,"岡 奈月"),
                new Customer(7605,"大森 れいな"),
                new Customer(7606,"川西 はるか"),
                new Customer(7607,"菅澤 綾"),
                new Customer(7608,"中原 翔"),
                new Customer(7609,"大泉 薫"),
                new Customer(7610,"矢野 小百合"),
                new Customer(7611,"加藤 芳正"),
                new Customer(7612,"三谷 南朋"),
                new Customer(7613,"大山 綾女"),
        };

    }
}
