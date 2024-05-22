CREATE TABLE IF NOT EXISTS hotel_room (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          title VARCHAR(255) NOT NULL,
                                          description TEXT,
                                          bedcount INT NOT NULL,
                                          price FLOAT NOT NULL,
                                          extras TEXT,
                                          images JSON
);

INSERT INTO hotel_room (title, description, bedcount, price, extras, images) VALUES
                                                                                 ('Deluxe Room', 'A spacious room with a beautiful view.', 2, 150.0, 'Free WiFi, Breakfast included', '["https://example.com/image1.jpg", "https://example.com/image2.jpg"]'),
                                                                                 ('Standard Room', 'A cozy room perfect for short stays.', 1, 100.0, 'Free WiFi', '["https://example.com/image3.jpg", "https://example.com/image4.jpg"]'),
                                                                                 ('Suite', 'An elegant suite with a living area.', 3, 300.0, 'Free WiFi, Breakfast included, Airport pickup', '["https://example.com/image5.jpg", "https://example.com/image6.jpg"]'),
                                                                                 ('Economy Room', 'A small room for budget travelers.', 1, 80.0, 'Free WiFi', '["https://example.com/image7.jpg", "https://example.com/image8.jpg"]'),
                                                                                 ('Presidential Suite', 'A luxurious suite with top amenities.', 4, 500.0, 'Free WiFi, Breakfast included, Airport pickup, Spa access', '["https://example.com/image9.jpg", "https://example.com/image10.jpg"]'),
                                                                                 ('Family Room', 'A room perfect for a family stay.', 4, 200.0, 'Free WiFi, Breakfast included', '["https://example.com/image11.jpg", "https://example.com/image12.jpg"]'),
                                                                                 ('Single Room', 'A comfortable room for solo travelers.', 1, 90.0, 'Free WiFi', '["https://example.com/image13.jpg", "https://example.com/image14.jpg"]'),
                                                                                 ('Double Room', 'A room with two beds.', 2, 120.0, 'Free WiFi', '["https://example.com/image15.jpg", "https://example.com/image16.jpg"]'),
                                                                                 ('Twin Room', 'A room with twin beds.', 2, 110.0, 'Free WiFi', '["https://example.com/image17.jpg", "https://example.com/image18.jpg"]'),
                                                                                 ('Honeymoon Suite', 'A romantic suite for newlyweds.', 1, 350.0, 'Free WiFi, Breakfast included, Spa access', '["https://example.com/image19.jpg", "https://example.com/image20.jpg"]'),
                                                                                 ('Business Suite', 'A suite with a work area for business travelers.', 1, 250.0, 'Free WiFi, Breakfast included', '["https://example.com/image21.jpg", "https://example.com/image22.jpg"]'),
                                                                                 ('Penthouse Suite', 'A top-floor suite with panoramic views.', 3, 450.0, 'Free WiFi, Breakfast included, Spa access', '["https://example.com/image23.jpg", "https://example.com/image24.jpg"]'),
                                                                                 ('Accessible Room', 'A room designed for accessibility.', 1, 100.0, 'Free WiFi, Accessible features', '["https://example.com/image25.jpg", "https://example.com/image26.jpg"]'),
                                                                                 ('Luxury Room', 'A room with luxurious furnishings.', 2, 220.0, 'Free WiFi, Breakfast included', '["https://example.com/image27.jpg", "https://example.com/image28.jpg"]'),
                                                                                 ('Executive Suite', 'A suite with executive amenities.', 2, 320.0, 'Free WiFi, Breakfast included, Airport pickup', '["https://example.com/image29.jpg", "https://example.com/image30.jpg"]');
