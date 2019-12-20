package com.nee.demo.cache;

import com.nee.demo.orm.model.DemoModel;

public class UserCache {

    private static ThreadLocal<DemoModel> map = new ThreadLocal<>();

    public static void setData(DemoModel model) {
        map.set(model);
    }

    public static DemoModel getData() {
        return map.get();
    }
}
