CREATE SEQUENCE IF NOT EXISTS orders_seq
      MINVALUE 1
      MAXVALUE 999999999
      INCREMENT BY 1
      START WITH 1;

CREATE TYPE order_state AS ENUM ('declined', 'accepted', 'delivering', 'delivered');

CREATE TABLE IF NOT EXISTS Orders (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT REFERENCES Users(id) NOT NULL,
    courier_id BIGINT REFERENCES Users(id),
    order_date TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    state order_state
);