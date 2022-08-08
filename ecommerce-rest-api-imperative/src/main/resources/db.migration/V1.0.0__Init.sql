create schema if not exists ecomm;

create TABLE IF NOT EXISTS ecomm.product (
	id uuid NOT NULL DEFAULT random_uuid(),
	name varchar(56) NOT NULL,
	description varchar(200),
	price numeric(16, 4) DEFAULT 0 NOT NULL,
	count numeric(8, 0),
	image_url varchar(40),
	PRIMARY KEY(id)
);

create TABLE IF NOT EXISTS ecomm.tag (
	id uuid NOT NULL DEFAULT random_uuid(),
	name varchar(20),
	PRIMARY KEY(id)
);

create TABLE IF NOT EXISTS ecomm.product_tag (
	product_id uuid NOT NULL DEFAULT random_uuid(),
	tag_id uuid NOT NULL,
	FOREIGN KEY (product_id)
		REFERENCES product(id),
	FOREIGN KEY(tag_id)
		REFERENCES tag(id)
);

create TABLE IF NOT EXISTS ecomm.user (
	id uuid NOT NULL DEFAULT random_uuid(),
	username varchar(16),
	password varchar(40),
	first_name varchar(16),
	last_name varchar(16),
	email varchar(24),
	phone varchar(24),
	user_status varchar(16),
	PRIMARY KEY(id)
);

create TABLE IF NOT EXISTS ecomm.address (
	id uuid NOT NULL DEFAULT random_uuid(),
	number varchar(24),
	residency varchar(32),
	street varchar(32),
	city varchar(24),
	state varchar(24),
	country varchar(24),
	pincode varchar(10),
	PRIMARY KEY(id)
);

create TABLE IF NOT EXISTS ecomm.user_address (
	user_id uuid NOT NULL DEFAULT random_uuid(),
	address_id uuid NOT NULL,
	FOREIGN KEY (user_id)
		REFERENCES ecomm.user(id),
	FOREIGN KEY(address_id)
		REFERENCES ecomm.address(id)
);

create TABLE IF NOT EXISTS ecomm.payment (
	id uuid NOT NULL DEFAULT random_uuid(),
	authorized boolean,
	message varchar(64),
	PRIMARY KEY(id)
);

create TABLE IF NOT EXISTS ecomm.card (
	id uuid NOT NULL DEFAULT random_uuid(),
	number varchar(16),
	user_id uuid NOT NULL UNIQUE,
	last_name varchar(16),
	expires varchar(5),
	cvv varchar(4),
	FOREIGN KEY(user_id)
		REFERENCES ecomm.user(id),
	PRIMARY KEY(id)
);

create TABLE IF NOT EXISTS ecomm.shipment (
	id uuid NOT NULL DEFAULT random_uuid(),
	est_delivery_date timestamp,
	carrier varchar(24),
	PRIMARY KEY(id)
);

create TABLE IF NOT EXISTS ecomm.orders (
	id uuid NOT NULL DEFAULT random_uuid(),
	customer_id uuid NOT NULL,
	address_id uuid NOT NULL,
	card_id uuid,
	order_date timestamp,
	total numeric(16, 4) DEFAULT 0 NOT NULL,
	payment_id uuid,
	shipment_id uuid,
	status varchar(24),
	PRIMARY KEY(id),
	FOREIGN KEY(customer_id)
		REFERENCES ecomm.user(id),
	FOREIGN KEY(address_id)
		REFERENCES ecomm.address(id),
	FOREIGN KEY(card_id)
		REFERENCES ecomm.card(id),
	FOREIGN KEY(payment_id)
		REFERENCES ecomm.payment(id),
  FOREIGN KEY(shipment_id)
		REFERENCES ecomm.shipment(id),
	PRIMARY KEY(id)
);

create TABLE IF NOT EXISTS ecomm.item (
	id uuid NOT NULL DEFAULT random_uuid(),
	product_id uuid NOT NULL,
	quantity numeric(8, 0),
	unit_price numeric(16, 4) NOT NULL,
  FOREIGN KEY(product_id)
		REFERENCES ecomm.product(id),
	PRIMARY KEY(id)
);

create TABLE IF NOT EXISTS ecomm.order_item (
  id uuid NOT NULL DEFAULT random_uuid(),
	order_id uuid NOT NULL,
	item_id uuid NOT NULL,
	FOREIGN KEY (order_id)
		REFERENCES ecomm.orders(id),
	FOREIGN KEY(item_id)
		REFERENCES ecomm.item(id)
);

create TABLE IF NOT EXISTS ecomm.authorization (
  id uuid NOT NULL DEFAULT random_uuid(),
	order_id uuid NOT NULL DEFAULT random_uuid(),
	authorized boolean,
	time timestamp,
	message varchar(16),
	error varchar(24),
	FOREIGN KEY (order_id)
		REFERENCES ecomm.orders(id),
	PRIMARY KEY(id)
);

create TABLE IF NOT EXISTS ecomm.cart (
  id uuid NOT NULL DEFAULT random_uuid(),
	user_id uuid NOT NULL DEFAULT random_uuid(),
	FOREIGN KEY (user_id)
		REFERENCES ecomm.user(id),
	PRIMARY KEY(id)
);

create TABLE IF NOT EXISTS ecomm.cart_item (
	cart_id uuid NOT NULL DEFAULT random_uuid(),
	item_id uuid NOT NULL DEFAULT random_uuid(),
	FOREIGN KEY (cart_id)
		REFERENCES ecomm.cart(id),
	FOREIGN KEY(item_id)
		REFERENCES ecomm.item(id)
);