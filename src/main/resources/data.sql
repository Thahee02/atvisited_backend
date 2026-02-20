-- Insert Categories
INSERT INTO categories (name, description, icon_url) VALUES
 ('Religious', 'Places of worship and spiritual significance', '/icons/religious.png'),
 ('Nature', 'Beaches, lagoons, and natural attractions', '/icons/nature.png'),
 ('Heritage', 'Historical and cultural sites', '/icons/heritage.png'),
 ('Educational', 'Universities and learning centers', '/icons/educational.png'),
 ('Beach', 'Coastal and beach locations', '/icons/beach.png');

-- Insert Places (Sainthamaruthu area)
INSERT INTO places (name, category_id, description, latitude, longitude, distance_from_home, estimated_cost, opening_time, closing_time, best_time_to_visit, parking_available, rating) VALUES
('Sainthamaruthu Grand Jummah Mosque', 1, 'One of the largest mosques in the Eastern Province, featuring beautiful Islamic architecture', 7.4567, 81.8234, 0.0, 0.00, '05:00:00', '21:00:00', 'Morning hours', true, 4.8),
('Oluvil Beach', 5, 'Beautiful sandy beach with palm trees, perfect for swimming and photography', 7.4333, 81.8500, 3.5, 0.00, '06:00:00', '18:00:00', '4:00 PM - 6:00 PM', true, 4.5),
('Oluvil Harbour', 5, 'Modern fishing harbor with scenic views of fishing boats and sea', 7.4300, 81.8480, 3.0, 0.00, '06:00:00', '18:00:00', 'Early morning', true, 4.2),
('South Eastern University', 4, 'Main university campus with modern architecture', 7.4200, 81.8400, 4.0, 0.00, '08:00:00', '17:00:00', 'Weekdays', true, 4.0),
('Kalmunai Beach', 5, 'Quiet beach ideal for relaxation and sunset views', 7.4167, 81.8167, 7.2, 0.00, '00:00:00', '00:00:00', 'Sunset time', true, 4.3),
('Thirukkovil Temple', 1, 'Historic Hindu temple with colorful architecture', 7.4000, 81.8000, 15.0, 0.00, '06:00:00', '20:00:00', 'Early morning', true, 4.7);

-- Insert Travel Tips
INSERT INTO travel_tips (place_id, tip, tip_type) VALUES
(1, 'Dress modestly, remove shoes before entering', 'DRESS_CODE'),
(1, 'Best to visit during non-prayer times', 'BEST_TIME'),
(2, 'Bring drinking water as no shops nearby', 'GENERAL'),
(2, 'Visit during sunset for beautiful photos', 'BEST_TIME'),
(3, 'Early morning is best to see fishing boats return', 'BEST_TIME');

-- Insert Sample Travel Plans
INSERT INTO travel_plans (title, tourist_name, visit_date, is_finalized) VALUES 
('Eastern Coast Weekend', 'Thahee', '2026-08-20', false),
('Heritage Exploration', 'Sarah', '2026-09-15', true);

-- Insert Sample Plan Items
INSERT INTO plan_items (plan_id, place_id, visit_order, estimated_arrival_time, estimated_duration_minutes, notes) VALUES
(1, 1, 1, '09:00', 60, 'Morning prayer and architecture view'),
(1, 2, 2, '11:00', 120, 'Beach time and photography'),
(2, 6, 1, '10:00', 90, 'Visit the historic temple'),
(2, 3, 2, '14:30', 60, 'Harbor tour');