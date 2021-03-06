package com.example.spusapp.Transaction;

import android.util.Log;

import com.midtrans.sdk.corekit.core.TransactionRequest;
import com.midtrans.sdk.corekit.models.BankType;
import com.midtrans.sdk.corekit.models.BillingAddress;
import com.midtrans.sdk.corekit.models.CustomerDetails;
import com.midtrans.sdk.corekit.models.ItemDetails;
import com.midtrans.sdk.corekit.models.ShippingAddress;
import com.midtrans.sdk.corekit.models.snap.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class DataCustumer {
    public static String NAME = "Muhammad Rizky Asyari";
    public static String PHONE = "082386914928";
    public static String EMAIL = "rizkyasyari7@gmail.com";
    public static String ADDRESS = "jl.Garuda Sakti";

    public static List<Product> getListProduct(){
        List<Product> list = new ArrayList<>();
        list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan Januari",
                1,
                1200000
        ));
        list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan Februari",
                1,
                1200000
        ));
        list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan Maret",
                1,
                1200000
        ));
        list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan April",
                1,
                1200000
        ));
        list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan Mei",
                1,
                1200000
        ));
        list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan Juni",
                1,
                1200000
        ));
        list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan Juli",
                1,
                1200000
        ));list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan Agustus",
                1,
                1200000
        ));list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan September",
                1,
                1200000
        ));list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan Oktober",
                1,
                1200000
        ));list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan November",
                1,
                1200000
        ));list.add(new Product("https://cdn4.iconfinder.com/data/icons/school-education-24/24/tuition_fee_fee_payday_payment_course_education_studying-512.png",
                "SPP Bulan Desember",
                1,
                1200000
        ));

        return list;
    }

    public static CustomerDetails customerDetails(){

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setFirstName(NAME);
        customerDetails.setPhone(PHONE);
        customerDetails.setEmail(EMAIL);

        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setAddress(ADDRESS);
        customerDetails.setShippingAddress(shippingAddress);

        return customerDetails;

    }

    public static TransactionRequest transactionRequest(String id, int price, int qty, String name,int position){

        int harga = getListProduct().get(position).getPrice();
        int kuantiti = getListProduct().get(position).getQty();
        int total = harga*kuantiti;
        TransactionRequest transactionRequest = new TransactionRequest(System.currentTimeMillis()+" ", total);

        transactionRequest.setCustomerDetails(customerDetails());

            ItemDetails details = new ItemDetails(id, price, qty, name);

            ArrayList<ItemDetails> itemDetails = new ArrayList<>();
            itemDetails.add(details);
            transactionRequest.setItemDetails(itemDetails);

            CreditCard creditCard = new CreditCard();
            creditCard.setSaveCard(false);
            creditCard.setAuthentication(CreditCard.AUTHENTICATION_TYPE_RBA);
            creditCard.setBank(BankType.BCA);
            transactionRequest.setCreditCard(creditCard);
            return transactionRequest;
        }

    }
