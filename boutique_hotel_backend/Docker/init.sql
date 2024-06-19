CREATE TABLE IF NOT EXISTS hotel_room (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          title VARCHAR(255) NOT NULL,
    description TEXT,
    bedcount INT NOT NULL,
    price FLOAT NOT NULL,
    extras TEXT,
    images JSON
    );

INSERT INTO hotel_db.hotel_room (id, available, bedcount, description, extras, images, price, title) VALUES
                                                                                                         (1, true, 2, 'A spacious room with a beautiful view.', 'Free WiFi, Breakfast included', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 150, 'Deluxe Room'),
                                                                                                         (2, true, 1, 'A cozy room perfect for short stays.', 'Free WiFi', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 100, 'Standard Room'),
                                                                                                         (3, true, 3, 'An elegant suite with a living area.', 'Free WiFi, Breakfast included, Airport pickup', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 300, 'Suite'),
                                                                                                         (4, true, 1, 'A small room for budget travelers.', 'Free WiFi', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 80, 'Economy Room'),
                                                                                                         (5, true, 4, 'A luxurious suite with top amenities.', 'Free WiFi, Breakfast included, Airport pickup, Spa access', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 500, 'Presidential Suite'),
                                                                                                         (6, true, 4, 'A room perfect for a family stay.', 'Free WiFi, Breakfast included', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 200, 'Family Room'),
                                                                                                         (7, true, 1, 'A comfortable room for solo travelers.', 'Free WiFi', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 90, 'Single Room'),
                                                                                                         (8, true, 2, 'A room with two beds.', 'Free WiFi', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 120, 'Double Room'),
                                                                                                         (9, true, 2, 'A room with twin beds.', 'Free WiFi', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 110, 'Twin Room'),
                                                                                                         (10, true, 1, 'A romantic suite for newlyweds.', 'Free WiFi, Breakfast included, Spa access', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 350, 'Honeymoon Suite'),
                                                                                                         (11, true, 1, 'A suite with a work area for business travelers.', 'Free WiFi, Breakfast included', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 250, 'Business Suite'),
                                                                                                         (12, true, 3, 'A top-floor suite with panoramic views.', 'Free WiFi, Breakfast included, Spa access', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 450, 'Penthouse Suite'),
                                                                                                         (13, true, 1, 'A room designed for accessibility.', 'Free WiFi, Accessible features', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 100, 'Accessible Room'),
                                                                                                         (14, true, 2, 'A room with luxurious furnishings.', 'Free WiFi, Breakfast included', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 220, 'Luxury Room'),
                                                                                                         (15, true, 2, 'A suite with executive amenities.', 'Free WiFi, Breakfast included, Airport pickup', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 320, 'Executive Suite'),
                                                                                                         (16, true, 2, 'A spacious room with a beautiful view.', 'Free WiFi, Breakfast included', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 150, 'Deluxe Room'),
                                                                                                         (17, true, 1, 'A cozy room perfect for short stays.', 'Free WiFi', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 100, 'Standard Room'),
                                                                                                         (18, true, 3, 'An elegant suite with a living area.', 'Free WiFi, Breakfast included, Airport pickup', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 300, 'Suite'),
                                                                                                         (19, true, 1, 'A small room for budget travelers.', 'Free WiFi', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 80, 'Economy Room'),
                                                                                                         (20, true, 4, 'A luxurious suite with top amenities.', 'Free WiFi, Breakfast included, Airport pickup, Spa access', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 500, 'Presidential Suite'),
                                                                                                         (21, true, 4, 'A room perfect for a family stay.', 'Free WiFi, Breakfast included', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 200, 'Family Room'),
                                                                                                         (22, true, 1, 'A comfortable room for solo travelers.', 'Free WiFi', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 90, 'Single Room'),
                                                                                                         (23, true, 2, 'A room with two beds.', 'Free WiFi', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 120, 'Double Room'),
                                                                                                         (24, true, 2, 'A room with twin beds.', 'Free WiFi', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 110, 'Twin Room'),
                                                                                                         (25, true, 1, 'A romantic suite for newlyweds.', 'Free WiFi, Breakfast included, Spa access', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 350, 'Honeymoon Suite'),
                                                                                                         (26, true, 1, 'A suite with a work area for business travelers.', 'Free WiFi, Breakfast included', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 250, 'Business Suite'),
                                                                                                         (27, true, 3, 'A top-floor suite with panoramic views.', 'Free WiFi, Breakfast included, Spa access', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 450, 'Penthouse Suite'),
                                                                                                         (28, true, 1, 'A room designed for accessibility.', 'Free WiFi, Accessible features', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 100, 'Accessible Room'),
                                                                                                         (29, true, 2, 'A room with luxurious furnishings.', 'Free WiFi, Breakfast included', '["https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4UlVfbXpFKiYPHYsNn0E1op-q1S3yva15Hg&s"]', 220, 'Luxury Room'),
                                                                                                         (30, true, 2, 'A suite with executive amenities.', 'Free WiFi, Breakfast included, Airport pickup', '["https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg", "https://media.istockphoto.com/id/492189224/photo/seaview-bedroom.jpg?s=612x612&w=0&k=20&c=tSL5OoSdxW3l7WzdBGU2_NnGNjDH88twjNZTTkll2jY="]', 320, 'Executive Suite');

