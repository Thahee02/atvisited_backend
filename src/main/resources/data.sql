-- Insert Categories
INSERT IGNORE INTO categories (id, name, description, icon_url) VALUES
 (1, 'Religious', 'Places of worship and spiritual significance', '/icons/religious.png'),
 (2, 'Nature', 'Beaches, lagoons, and natural attractions', '/icons/nature.png'),
 (3, 'Heritage', 'Historical and cultural sites', '/icons/heritage.png'),
 (4, 'Educational', 'Universities and learning centers', '/icons/educational.png'),
 (5, 'Beach', 'Coastal and beach locations', '/icons/beach.png');

-- Insert Places
INSERT IGNORE INTO places (id, name, category_id, description, latitude, longitude, distance_from_home, estimated_cost, opening_time, closing_time, best_time_to_visit, parking_available, rating, historical_background, cultural_significance, transport_options, safety_guidelines, local_customs, nearby_facilities, suitable_for, washrooms_available, estimated_visit_duration, image_url) VALUES
(1, 'Sainthamaruthu Grand Jummah Mosque', 1, 'One of the largest mosques in the Eastern Province, featuring beautiful Islamic architecture and serving as a spiritual hub for the community.', 7.3925, 81.8349, 0.0, 0.00, '05:00:00', '21:00:00', 'Morning hours', true, 5.0, 
'Built several decades ago, it has undergone multiple renovations to become the architectural marvel it is today. It represents the long-standing Islamic heritage of the Eastern Province.', 
'It is a key landmark for the Muslim community in Sainthamaruthu and hosts thousands of worshippers during Friday prayers and Eid festivals.',
'Easily accessible via local tuk-tuks (LKR 100-200 from town) or a 5-minute walk from the main Sainthamaruthu junction.',
'Stay hydrated; the courtyard can get warm. Please maintain silence inside the prayer hall.',
'Modest dress is required. Women should wear headscarves, and men should wear long trousers. Shoes must be removed before entering.',
'Ablution areas available inside. Numerous local tea shops and restaurants are just outside the gates.',
'Families welcome. Special prayer areas for women are available.', true, '45 minutes', 'https://i.ytimg.com/vi/0LcQuyOyynE/sddefault.jpg'),

(2, 'Oluvil Lighthouse', 5, 'Beautiful white lighthouse standing tall against the blue sea, perfect for photography and enjoying coastal breezes.', 7.2902, 81.87, 13.7, 0.00, '06:00:00', '18:00:00', '4:00 PM - 6:00 PM', true, 4.3,
'Constructed as part of the Oluvil Harbour development, this lighthouse has quickly become a popular tourist spot for its modern design and height.',
'A symbol of the region''s maritime development and a key navigational aid for local fishermen.',
'Take the A2 highway towards Akkaraipattu and turn towards the Oluvil Harbour road. Best reached by private vehicle or tuk-tuk.',
'Climbing the lighthouse may be restricted. Stay behind safety barriers near the coastline.',
'Standard coastal etiquette applies. Avoid littering on the beach.',
'Mobile food carts often available during evening hours. No permanent restrooms on site.',
'Great for families and couples. Children should be supervised near the water.', false, '30 minutes', 'https://i.ytimg.com/vi/gOGw57D5Xr4/maxresdefault.jpg'),

(3, 'Oluvil Harbour', 5, 'Modern fishing harbor with scenic views of fishing boats and the vast Indian Ocean.', 7.2782, 81.8684, 14.9, 0.00, '06:00:00', '18:00:00', 'Early morning', true, 4.2,
'The harbor was developed to boost the local fishing industry and international trade, featuring modern docking facilities.',
'It serves as a vital economic lifeline for the Eastern fishing community.',
'Located right next to the Oluvil Lighthouse. Bus routes are available to Oluvil town, followed by a short tuk-tuk ride.',
'Be careful of slippery surfaces near the docks. Watch out for moving fishing vehicles.',
'Respect the hard-working fishermen; ask permission before taking close-up photos of their catch.',
'Fresh fish market nearby. Small cafes serving local breakfast are available early in the morning.',
'Excellent for educational trips and family outings.', true, '1 hour', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRz-M6L7Yc7rWvP0u8pY6X0f-k19_M2vS_QJQ&s'),

(4, 'South Eastern University', 4, 'Main university campus with modern architecture and a serene academic environment.', 7.3009, 81.8597, 11.4, 0.00, '08:00:00', '17:00:00', 'Weekdays', true, 4.0,
'Established in 1995, SEUSL is a premier higher education institution in the Eastern Province, contributing significantly to the region''s academic growth.',
'A symbol of educational progress and harmony among diverse communities in Sri Lanka.',
'Located in Oluvil. Accessible by intercity buses and local transport.',
'Visitors should register at the main gate. Photography of certain buildings may require permission.',
'Maintain a quiet environment suitable for academic activities. Respect the dress code of students.',
'University canteen and several small eateries near the campus gates.',
'Great for prospective students and those interested in modern architecture.', true, '1.5 hours', 'https://archives1.dailynews.lk/sites/default/files/news/2020/07/28/z_p01-South.jpg'),

(5, 'Kalmunai Beach', 5, 'Quiet beach ideal for relaxation and sunset views with a wide sandy shore.', 7.4124, 81.8396, 3.1, 0.00, '00:00:00', '00:00:00', 'Sunset time', true, 4.3,
'Known historically as an important coastal stop, it now serves as a major recreational space for the Kalmunai city inhabitants.',
'A site for local community gatherings and traditional kite flying during the seasonal winds.',
'Just a few kilometers from Sainthamaruthu. Can be reached by bike, tuk-tuk, or a long walk.',
'Avoid swimming during monsoon seasons as the currents can be strong.',
'Be mindful of the local community; avoid loud noises in the late evenings.',
'Kiosks selling spicy snacks (Wade) and fresh coconut water are common during sunset.',
'Highly recommended for families. Lots of space for children to play.', false, '2 hours', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3y5x8E9j6J6X_6yY-yY9Y-yY9Y-yY9Y-yY9A&s'),

(6, 'Heritage Cultural Center', 3, 'A building showcasing the rich history and traditions of the Ampara district.', 7.3500, 81.8000, 5.0, 100.00, '09:00:00', '17:00:00', 'Morning', true, 4.5, 
'Built to preserve local history.', 'Cultural hub.', 'Local bus.', 'No food inside.', 'Respect exhibits.', 'Toilets available.', 'Students.', true, '1 hour', 'https://images.unsplash.com/photo-1518709268805-4e9042fb9f23'),

(10, 'Sri Kannaki Amman Kovil - Karaitivu', 1, 'Historic Hindu temple in Karaitivu dedicated to Goddess Kannaki, known for its spiritual atmosphere.', 7.3818, 81.8384, 1.3, 0.00, '05:30:00', '20:00:00', 'Festival days', true, 4.6,
'One of the oldest temples in the region, with roots tracing back centuries. It has a unique architectural style characteristic of Eastern Sri Lankan Kovils.',
'Central to the cultural and religious identity of the Tamil community in Karaitivu, especially during the annual festival.',
'Located in Karaitivu, just a 5-minute tuk-tuk ride from Sainthamaruthu.',
'Photography inside the inner sanctum is strictly prohibited. Wash hands and feet before entering.',
'Remove shoes before entering the temple premises. Dress modestly.',
'Traditional prasad is often available. Small shops nearby sell flowers and religious items.',
'Suitable for peaceful visits and cultural exploration.', true, '1 hour', 'https://lh3.googleusercontent.com/gps-cs-s/AHVAwer...'),

(14, 'Mahavapi Maha Viharaya', 1, 'Buddhist temple in Ampara town visited by the Sinhala community, offering a peaceful retreat.', 7.2978, 81.6714, 24.9, 0.00, '06:00:00', '19:00:00', 'Morning and Poya days', true, 4.4,
'A significant religious site in the Ampara district, representing the Buddhist heritage of the island.',
'A place of worship, meditation, and community gathering for Buddhists during Poya days.',
'Located in Ampara town. Best reached by car or intercity bus from Kalmunai.',
'Maintain silence. Do not touch or climb on statues.',
'White or light-colored modest clothing is preferred. Remove shoes and hats.',
'Rest areas and water fountains available in the temple grounds.',
'Comfortable for elderly visitors and families.', true, '1.5 hours', 'https://lh3.googleusercontent.com/gps-cs-s/AHVAweo...'),

(9, 'Maruthamunai Beach', 5, 'Scenic coastal stretch close to Maruthamunai town, famous for its surfing potential and weaving industry nearby.', 7.4363, 81.8232, 5.6, 0.00, '00:00:00', '00:00:00', 'Evening', true, 4.3,
'Maruthamunai is traditionally known for its handloom textile industry. The beach has been a central part of the village life for generations.',
'A place where local traditions of fishing and textile weaving meet the sea.',
'Easily reachable by bus or tuk-tuk from Sainthamaruthu (approx. 10-15 mins).',
'Swimming is recommended only in designated areas. Be aware of fishing nets.',
'Respect the privacy of local residents and the active fishing community.',
'Known for nearby textile shops where you can buy traditional handloom Sarongs and Sarees.',
'Family-friendly with plenty of space for beach activities.', false, '2 hours', 'https://lh3.googleusercontent.com/gps-cs-s/AHVAwep...'),

(11, 'Nintavur Jummah Mosque', 1, 'Major mosque serving the Muslim community in Nintavur, known for its large prayer hall and community work.', 7.3985, 81.832, 4.8, 0.00, '05:00:00', '21:00:00', 'Friday prayers', true, 4.5,
'A historic religious center in Nintavur that has supported the spiritual life of the area for many decades.',
'Acts as a central point for religious education and community services in the Nintavur region.',
'Located on the main road in Nintavur. High accessibility via all modes of transport.',
'Maintain decorum during prayer times. Avoid walking in front of people praying.',
'Islamic modest dress code applies. Remove footwear before entering.',
'Nearby local markets offer a variety of traditional Eastern Sri Lankan foods.',
'Suitable for all, with separate areas for men and women.', true, '30 minutes', 'https://thumbs.dreamstime.com/b/anuradhapura-sri-l...'),

(12, 'Addalaichenai National College of Education', 4, 'Well-known Islamic educational institution in the region, training the next generation of teachers.', 7.2418, 81.8548, 17.4, 0.00, '08:00:00', '16:00:00', 'Weekdays', true, 4.4,
'Established to provide high-quality teacher training, it has become a cornerstone of education in the Addalaichenai area.',
'Plays a vital role in preserving and promoting intellectual growth in the Eastern Province.',
'Accessible via the main coastal road towards Akkaraipattu.',
'Visitors should check in at the security gate. Some academic areas are restricted.',
'Modest attire is expected within the campus premises.',
'Canteen facilities available for staff and visitors.',
'Good for academic visits and educational tours.', true, '1 hour', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:AN...'),

(13, 'ATI - Sammanthurai', 4, 'Advanced Technological Institute providing vocational and technical training to the local youth.', 7.3538, 81.7813, 10, 0.00, '08:00:00', '16:00:00', 'Weekdays', true, 4.1,
'Part of the SLIATE network, this institute has been key in providing technical skills to the youth of the Sammanthurai region.',
'A symbol of modern technical progress and empowerment through education.',
'Located in Sammanthurai town, accessible by bus from Kalmunai or Ampara.',
'Follow campus safety signs. Visitors should notify the administration office.',
'General academic decorum is expected.',
'Close to Sammanthurai town center with many food options.',
'Educational visits for students are encouraged.', true, '1 hour', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:AN...');

-- Insert Travel Tips
INSERT IGNORE INTO travel_tips (id, place_id, tip, tip_type) VALUES
(1, 1, 'Dress modestly, remove shoes before entering', 'DRESS_CODE'),
(2, 1, 'Best to visit during non-prayer times', 'BEST_TIME'),
(3, 2, 'Bring drinking water as no shops nearby', 'GENERAL'),
(4, 2, 'Visit during sunset for beautiful photos', 'BEST_TIME'),
(5, 3, 'Early morning is best to see fishing boats return', 'BEST_TIME'),
(6, 9, 'Check out the local handloom shops nearby', 'GENERAL'),
(7, 10, 'Great spiritual atmosphere during evening Pooja', 'BEST_TIME');

-- Insert Sample Travel Plans
INSERT IGNORE INTO travel_plans (id, title, tourist_name, visit_date, is_finalized) VALUES 
(1, 'Eastern Coast Weekend', 'Thahee', '2026-08-20', false),
(2, 'Heritage Exploration', 'Sarah', '2026-09-15', true);

-- Insert Sample Plan Items
INSERT IGNORE INTO plan_items (id, travel_plan_id, place_id, visit_order, estimated_arrival_time, estimated_duration_minutes, notes) VALUES
(1, 1, 1, 1, '09:00', 60, 'Morning prayer and architecture view'),
(2, 1, 2, 2, '11:00', 120, 'Beach time and photography'),
(3, 2, 6, 1, '10:00', 90, 'Visit the historic temple'),
(4, 2, 3, 2, '14:30', 60, 'Harbor tour');