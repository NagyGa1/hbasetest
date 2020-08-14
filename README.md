# Summary

Various tests for HBase / Hive SQL query performance.

# Hive schema

rowkey is item_sk string in reverse + ss_ticket_number string, concatenated with '#'

```hiveql
CREATE TABLE Store_Sales (
itemSkTicketNo string, ss_sold_at timestamp,
c_customer_sk string, s_store_sk string,
ss_quantity integer, ss_wholesale_cost decimal(7,2), ss_list_price decimal(7,2), ss_sales_price decimal(7,2),
ss_ext_discount_amt decimal(7,2), ss_ext_sales_price decimal(7,2), ss_ext_wholesale_cost decimal(7,2),
ss_ext_list_price decimal(7,2), ss_ext_tax decimal(7,2), ss_coupon_amt decimal(7,2),
ss_net_paid decimal(7,2), ss_net_paid_inc_tax decimal(7,2), ss_net_profit decimal(7,2),
i_item_sk string, i_item_id string, i_rec_start_date date, i_rec_end_date date, i_item_desc string,
i_current_price decimal(7,2), i_wholesate_cost decimal(7,2), i_brand_id integer, i_brand string,
i_class_id integer, i_class string, i_category_id integer, i_category string, i_manufact_id integer,
i_manufact string, i_size string, i_formulation string, i_color string, i_units string, i_container string,
i_manager_id integer, i_product_name string,
cd_demo_sk string, cd_gender char(1), cd_marital_status char(1), cd_education_status varchar(20),
cd_purchase_estimate integer, cd_credit_rating varchar(10), cd_dep_count integer, cd_dep_employed_count integer,
cd_dep_college_count integer,
hd_demo_sk string, hd_buy_potential char(15), hd_dep_count integer, hd_vehicle_count integer,
ib_income_band_sk string, ib_lower_bound integer, ib_upper_bound integer
)
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
WITH SERDEPROPERTIES ("hbase.columns.mapping" =
":key,:timestamp,
ss:customer_sk,ss:store_sk,
ss:quantity,ss:wholesale_cost,ss:list_price,ss:sales_price,
ss:ext_discount,ss:ext_sales_price,ss:ext_wholesale_cost,
ss:ext_list_price,ss:ext_tax,ss:coupon_amt,
ss:net_paid,ss:net_paid_inc_tax,ss:net_profit,
i:item_sk,i:item_id,i:rec_start_date,i:rec_end_date,i:item_desc,
i:current_price,i:wholesale_cost,i:brand_id,i:brand,
i:class_id,i:class,i:category_id,i:category,i:manufact_id,
i:manufact,i:size,i:formulation,i:color,i:units,i:container,
i:manager_id,i:product_name,
cd:demo_sk,cd:gender,cd:marital_status,cd:education_status,
cd:purchase_estimate,cd:credit_rating,cd:dep_count,cd:dep_employed_count,
cd:dep_college_count,
hd:demo_sk,hd:buy_potential,hd:dep_count,hd:vehicle_count,
ib:income_band_sk,ib:lower_bound,ib:upper_bound"
);

CREATE TABLE Customer (
c_customer_sk string, c_customer_id char(16),
c_first_shipto_date date, c_first_sales_date date, c_salutation char(10), c_first_name char(20),
c_last_name char(30), c_preferred_cust_flag char(1), c_birth_date date, c_birth_country varchar(20),
c_login char(13), c_email_address char(50), c_last_review_date date,
ca_address_sk string, ca_address_id char(16),
ca_street_number char(10), ca_street_name varchar(60), ca_street_type char(15), ca_suite_number char(10),
ca_city varchar(60), ca_county varchar(30), ca_state char(2), ca_zip char(10), ca_country varchar(20),
ca_gmt_offset decimal(5,2), ca_location_type char(20)
)
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
WITH SERDEPROPERTIES ("hbase.columns.mapping" =
":key, c:customer_id,
c:first_shipto_date,c:first_sales_date,c:salutation,c:first_name,
c:last_name,c:preferred_cust_flag,c:birth_date,c:birth_country,
c:login,c:email_address,c:last_review_date,
ca:address_sk,ca:address_id,
ca:street_number,ca:street_name,ca:street_type,ca:suite_number,
ca:city,ca:county,ca:state,ca:zip,ca:country,
ca:gmt_offset,ca:location_type"
);

CREATE TABLE Store (
s_store_sk string, s_store_id string, s_rec_start_date date, s_rec_end_date date, s_closed_date date,
s_store_name string, s_number_employees integer, s_floor_space integer, s_hours string, s_manager string,
s_market_id integer, s_geography_class string, s_market_desc string, s_market_manager string,
s_division_id integer, s_division_name string, s_company_id integer, s_company_name string,
s_street_number string, s_street_name string, s_street_type string, s_suite_number string,
s_city string, s_county string, s_state string, s_zip string, s_country string, s_gmt_offset decimal(5,2),
s_tax_percentage decimal(5,2)
)
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
WITH SERDEPROPERTIES ("hbase.columns.mapping" =
":key,s:store_id,s:rec_start_date,s:rec_end_date,s:closed_date,
s:store_name,s:number_employees,s:floor_space,s:hours,s:manager,
s:market_id,s:geography_class,s:market_desc,s:market_manager,
s:division_id,s:division_name,s:company_id,s:company_name,
s:street_number,s:street_name,s:street_type,s:suite_number,
s:city,s:county,s:state,s:zip,s:country,s:gmt_offset,
s:tax_percentage"
);
```

