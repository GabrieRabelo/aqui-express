drop table if exists sale_sale_item_list CASCADE;

-- INSERT INTO product (id, description, price) values (1, 'Fogao Dako', 499.90);
-- INSERT INTO product (id, description, price) values (2, 'Geladeira Brastemp', 899.90);
-- INSERT INTO product (id, description, price) values (3, 'Celular Hi Phone', 349.90);
-- INSERT INTO product (id, description, price) values (4, 'TV Pirata', 1499.90);
-- INSERT INTO product (id, description, price) values (5, 'Computador Dell', 30.00);
--
-- INSERT INTO inventory_item(id, available_quantity) values (1, 10);
-- INSERT INTO inventory_item(id, available_quantity) values (2, 10);
-- INSERT INTO inventory_item(id, available_quantity) values (3, 10);
-- INSERT INTO inventory_item(id, available_quantity) values (4, 10);
-- INSERT INTO inventory_item(id, available_quantity) values (5, 10);

CREATE TABLE IF NOT EXISTS sale_sale_item_list (
    sale_id int not null,
    sale_item_list_id int not null
);

INSERT INTO sale(id, date) values (6, null);
INSERT INTO sale_item(id, quantity, product_id, current_price, taxes, sale_id) values (7, 10, 1, 499.90 , 0, 6);
INSERT INTO sale_sale_item_list(sale_id, sale_item_list_id) values (6, 7);
