-- =====================
-- Insert into train_model (Main Table)
-- =====================
INSERT INTO train_list (train_number, train_name, source, destination, date_of_journey, time_of_journey)
VALUES
(12345, 'Superfast Express', 'Chennai', 'Delhi', '2025-07-01', '08:00:00'),
(67890, 'Night Rider', 'Mumbai', 'Bangalore', '2025-07-02', '22:30:00');

-- =====================
-- Insert Intermediate Stations (List<String>)
-- =====================
INSERT INTO train_list_intermediate_station (train_list_train_number, intermediate_station)
VALUES
(12345, 'Katpadi'),
(12345, 'Gudur'),
(12345, 'Bhopal'),

(67890, 'Pune'),
(67890, 'Hubli');

-- =====================
-- Insert Class Seats Map (Map<String, Integer>)
-- =====================
INSERT INTO train_class_seats (train_number, class_type, seats_available)
VALUES
(12345, 'SL', 340),
(12345, '3A', 200),
(12345, '2A', 100),

(67890, '1A', 50),
(67890, '2A', 120),
(67890, 'SL', 400);
