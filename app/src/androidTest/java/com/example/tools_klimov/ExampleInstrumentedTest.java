package com.example.tools_klimov;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.example.network.datas.basket.BasketCreate;
import com.example.network.datas.basket.BasketDelete;
import com.example.network.datas.basket.BasketGet;
import com.example.network.datas.basket.BasketUpdate;
import com.example.network.datas.order.OrderGet;
import com.example.network.datas.product.ProductByUser;
import com.example.network.datas.product.ProductCreate;
import com.example.network.datas.product.ProductDelete;
import com.example.network.datas.product.ProductGet;
import com.example.network.datas.product.ProductGetOne;
import com.example.network.datas.product.ProductSearch;
import com.example.network.datas.product.ProductUpdate;
import com.example.network.datas.stock.StockGet;
import com.example.network.datas.users.UserCreate;
import com.example.network.datas.users.UserGet;
import com.example.network.datas.users.UserLogin;
import com.example.network.datas.users.UserLogout;
import com.example.network.datas.users.UserSend;
import com.example.network.datas.users.UserUpdate;
import com.example.network.domains.callbacks.MyResponseCallback;
import com.example.network.domains.common.Settings;
import com.example.network.domains.models.Basket;
import com.example.network.domains.models.Product;
import com.example.network.domains.models.User;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void UserLogin() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        User User = new User("testing@mail.ru", "Asdfg123*");

        new UserLogin(
                User,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER LOGIN", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("USER LOGIN", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void UserCreate() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        User User = new User("klimov@mail.ru", "228", "Степан", "Андреевич", "Климов", 0);

        new UserCreate(
                User,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER CREATE", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("USER CREATE", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void UserUpdate() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        User User = new User("stepan@mail.ru", "2282", "Степан", "Андреевич", "Климов", 0);

        new UserUpdate(
                User,
                Settings.DEMO_TOKEN,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER UPDATE", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("USER UPDATE", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void UserGet() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new UserGet(
                Settings.DEMO_TOKEN,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER GET", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("USER GET", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void UserLogout() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new UserLogout(
                Settings.DEMO_TOKEN,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER LOGOUT", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("USER LOGOUT", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void UserSend() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new UserSend(
                "stepan@mail.ru",
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER SEND", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("USER SEND", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void BasketGet() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new BasketGet(
                Settings.DEMO_TOKEN,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("BASKET GET", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("BASKET GET", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void BasketCreate() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        Basket Basket = new Basket(1, 8);

        new BasketCreate(
                Settings.DEMO_TOKEN,
                Basket,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("BASKET CREATE", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("BASKET CREATE", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void BasketUpdate() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        Basket Basket = new Basket(1, 10);

        new BasketUpdate(
                Settings.DEMO_TOKEN,
                Basket,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("BASKET UPDATE", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("BASKET UPDATE", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void BasketDelete() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new BasketDelete(
                Settings.DEMO_TOKEN,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("BASKET UPDATE", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("BASKET UPDATE", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void OrderGet() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new OrderGet(
                1,
                Settings.DEMO_TOKEN,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("ORDER GET", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("ORDER GET", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void ProductGet() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new ProductGet(
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("PRODUCT GET", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("PRODUCT GET", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void ProductGetOne() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new ProductGetOne(
                1,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("PRODUCT GET ONE", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("PRODUCT GET ONE", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void ProductSearch() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new ProductSearch(
                "faf",
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("PRODUCT SEARCH", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("PRODUCT SEARCH", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void ProductByUser() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new ProductByUser(
                Settings.DEMO_TOKEN,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("PRODUCT BY USER", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("PRODUCT BY USER", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void ProductCreate() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        Product Product = new Product("Игрушка робот", "Робот Галактус", 0, "100 гр.", 1000, "8438581f-85a9-4a12-a2fd-97518562d02a.doc");

        new ProductCreate(
                Settings.DEMO_TOKEN,
                Product,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("PRODUCT CREATE", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("PRODUCT CREATE", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void ProductUpdate() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        Product Product = new Product("Игрушка робот", "Робот Галактус", 0, "100 гр.", 1000, "8438581f-85a9-4a12-a2fd-97518562d02a.doc");

        new ProductUpdate(
                Settings.DEMO_TOKEN,
                1,
                Product,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("PRODUCT UPDATE", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("PRODUCT UPDATE", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void ProductDelete() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new ProductDelete(
                Settings.DEMO_TOKEN,
                1,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("PRODUCT DELETE", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("PRODUCT DELETE", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }

    @Test
    public void StockGet() throws InterruptedException {
        final Boolean[] Success = {false};

        CountDownLatch Latch = new CountDownLatch(1);

        new StockGet(
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("STOCK GET", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("STOCK GET", error);
                        Latch.countDown();
                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);

        assertTrue(Success[0]);
    }
}