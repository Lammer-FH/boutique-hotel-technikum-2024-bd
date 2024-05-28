CREATE DATABASE IF NOT EXISTS hotel_db;

USE hotel_db;

CREATE TABLE IF NOT EXISTS hotel_room (
                                          id INT PRIMARY KEY,
                                          bedcount INT,
                                          description VARCHAR(255),
                                          extras VARCHAR(255),
                                          images VARCHAR(255),
                                          price DECIMAL(10, 2),
                                          title VARCHAR(255)
);

INSERT INTO hotel_room (id, bedcount, description, extras, images, price, title) VALUES
                                                                                     (1, 2, 'A cozy room with a queen-sized bed and modern amenities.', 'WiFi, Breakfast included', 'https://example.com/images/room1.jpg', 120.00, 'Cozy Queen Room'),
                                                                                     (2, 1, 'A compact single room with essential facilities.', 'WiFi', 'https://example.com/images/room2.jpg', 80.00, 'Single Room'),
                                                                                     (3, 3, 'Spacious room with three beds, ideal for families.', 'WiFi, Breakfast included, TV', 'https://example.com/images/room3.jpg', 150.00, 'Family Room'),
                                                                                     (4, 2, 'A luxurious room with a king-sized bed and a beautiful view.', 'WiFi, Breakfast included, Mini Bar', 'https://example.com/images/room4.jpg', 200.00, 'Deluxe King Room'),
                                                                                     (5, 1, 'A budget-friendly room with basic facilities.', 'WiFi', 'https://example.com/images/room5.jpg', 50.00, 'Economy Room'),
                                                                                     (6, 2, 'A modern room with two twin beds and a city view.', 'WiFi, Breakfast included', 'https://example.com/images/room6.jpg', 110.00, 'Twin Room with City View'),
                                                                                     (7, 4, 'A large suite with two bedrooms and a living area.', 'WiFi, Breakfast included, Kitchenette', 'https://example.com/images/room7.jpg', 250.00, 'Two-Bedroom Suite'),
                                                                                     (8, 1, 'A small room with a single bed, perfect for solo travelers.', 'WiFi', 'https://example.com/images/room8.jpg', 70.00, 'Solo Traveler Room'),
                                                                                     (9, 2, 'A stylish room with a double bed and contemporary design.', 'WiFi, Breakfast included, Mini Bar', 'https://example.com/images/room9.jpg', 130.00, 'Modern Double Room'),
                                                                                     (10, 3, 'A family suite with three beds and a small kitchenette.', 'WiFi, Breakfast included, TV, Kitchenette', 'https://example.com/images/room10.jpg', 180.00, 'Family Suite with Kitchenette'),
                                                                                     (11, 2, 'An elegant room with two queen beds and luxurious decor.', 'WiFi, Breakfast included, Pool access', 'https://t3.ftcdn.net/jpg/02/94/19/40/240_F_294194023_disE35GtlVLDQx4caNDaWewZI8LbxWFQ.jpg', 160.00, 'Elegant Queen Room'),
                                                                                     (12, 1, 'A budget-friendly room with all the essential amenities.', 'WiFi, Breakfast included', 'https://media.nomadicmatt.com/2023/cheaphotelrooms.jpg', 60.00, 'Budget Room'),
                                                                                     (13, 2, 'A luxurious suite with a stunning view and modern facilities.', 'WiFi, Breakfast included, Mini Bar, Pool access', 'https://image-tc.galaxy.tf/wijpeg-364yimb2uoy1s84rln7r180in/vanderwarker-pdv-1521c-no-down-1-result.jpg', 220.00, 'Luxury Suite');
