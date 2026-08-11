-- ============================================================
-- AssistiveKart - Seed Data
-- Only inserts if tables are empty (uses INSERT IGNORE)
-- ============================================================

-- -------------------------------------------------------
-- Categories
-- -------------------------------------------------------
INSERT IGNORE INTO categories (id, name, slug, icon, image_url, description, product_count) VALUES
(1,  'Wheelchairs',                'wheelchairs',               'Armchair',        'https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=600&q=80', 'Manual and electric wheelchairs for enhanced mobility', 4),
(2,  'Mobility Aids',              'mobility-aids',             'PersonStanding',  'https://images.unsplash.com/photo-1576765608535-5f04d1e3f289?w=600&q=80', 'Comprehensive mobility solutions for everyday independence', 3),
(3,  'Walking Sticks',             'walking-sticks',            'Minus',           'https://images.unsplash.com/photo-1581579438747-1dc8d1e058c6?w=600&q=80', 'Ergonomic walking sticks and canes for balance support', 2),
(4,  'Crutches',                   'crutches',                  'ArrowUpDown',     'https://images.unsplash.com/photo-1584515933487-779824d29309?w=600&q=80', 'Lightweight and durable crutches for injury recovery', 2),
(5,  'Walkers & Rollators',        'walkers-rollators',         'Move',            'https://images.unsplash.com/photo-1579684385127-1ef15d508118?w=600&q=80', 'Walkers and rollators for safe, stable movement', 2),
(6,  'Orthopedic Supports',        'orthopedic-supports',       'Shield',          'https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=600&q=80', 'Braces, supports, and orthopedic aids for joint relief', 5),
(7,  'Wheelchair Cushions',        'wheelchair-cushions',       'Square',          'https://images.unsplash.com/photo-1586023492125-27b2c045efd7?w=600&q=80', 'Ergonomic foam and gel cushions for wheelchair seating', 3),
(8,  'Bathroom Safety',            'bathroom-safety',           'ShowerHead',      'https://images.unsplash.com/photo-1584622650111-993a426fbf0a?w=600&q=80', 'Shower chairs, grab bars, and safety rails for wet areas', 4),
(9,  'Daily Living Aids',          'daily-living-aids',         'Hand',            'https://images.unsplash.com/photo-1628771065518-0d82f1938462?w=600&q=80', 'Adaptive tools, pill organizers, and reachers for daily tasks', 4),
(10, 'Hearing Assistance',         'hearing-assistance',        'Ear',             'https://images.unsplash.com/photo-1598256989800-fe5f95da9787?w=600&q=80', 'Hearing amplifiers and discreet sound assistance', 1),
(11, 'Vision Assistance',          'vision-assistance',         'Eye',             'https://images.unsplash.com/photo-1591076482161-42ce6da69f67?w=600&q=80', 'Magnification lenses and illuminated visual aids', 1),
(12, 'Therapy & Rehabilitation',   'therapy-rehabilitation',    'Dumbbell',        'https://images.unsplash.com/photo-1571019614242-c5c5dee9f50b?w=600&q=80', 'Rehabilitation equipment, bands, and exercisers', 4),
(13, 'Pediatric Mobility',         'pediatric-mobility',        'Baby',            'https://images.unsplash.com/photo-1502086223501-7ea6ecd79368?w=600&q=80', 'Mobility solutions specifically tailored for children', 1),
(14, 'Smart Assistive Devices',    'smart-assistive-devices',   'Cpu',             'https://images.unsplash.com/photo-1510017803434-a899398421b3?w=600&q=80', 'GPS trackers, SOS emergency units, and smart devices', 4),
(15, 'Medical Monitoring Devices', 'medical-monitoring-devices','Activity',        'https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=600&q=80', 'Blood pressure monitors, oximeters, and diagnostic kits', 5);

-- -------------------------------------------------------
-- Products
-- -------------------------------------------------------
INSERT IGNORE INTO products (id, title, price, rating, category, category_slug, image_url, description, is_new, is_trending, stock, brand) VALUES
(1,  'Premium Manual Wheelchair',      349.99, 4.8, 'Wheelchairs',               'wheelchairs',               'https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=600&q=80', 'Lightweight and durable manual wheelchair with ergonomic design for maximum comfort and easy maneuverability. Perfect for both indoor and outdoor use.', FALSE, TRUE,  25, 'MobilityPro'),
(2,  'Electric Power Wheelchair',     1299.99, 4.9, 'Wheelchairs',               'wheelchairs',               'https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=600&q=80', 'Advanced electric wheelchair with intelligent joystick control, long-lasting battery life, and premium comfort features for complete independence.', TRUE,  TRUE,  12, 'ElectraMove'),
(3,  'Foldable Travel Wheelchair',     499.99, 4.7, 'Wheelchairs',               'wheelchairs',               'https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=600&q=80', 'Ultra-lightweight foldable wheelchair perfect for travel and transport. Fits in most car trunks and airplane overhead compartments.', TRUE,  FALSE, 18, 'TravelEase'),
(4,  'Sports Active Wheelchair',       899.99, 4.6, 'Wheelchairs',               'wheelchairs',               'https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=600&q=80', 'High-performance sports wheelchair designed for active individuals. Engineered for agility, speed, and competitive use.', FALSE, TRUE,   8, 'ActiveSport'),
(5,  'Ergonomic Walking Stick',         39.99, 4.5, 'Walking Sticks',            'walking-sticks',            'https://images.unsplash.com/photo-1581579438747-1dc8d1e058c6?w=600&q=80', 'Adjustable height walking stick with ergonomic soft-grip handle and non-slip rubber tip. Ideal for daily walks and balance support.', FALSE, FALSE, 45, 'StepSure'),
(6,  'Quad Cane with LED Light',        54.99, 4.7, 'Walking Sticks',            'walking-sticks',            'https://images.unsplash.com/photo-1581579438747-1dc8d1e058c6?w=600&q=80', 'Four-point base quad cane with built-in LED light for enhanced stability and nighttime visibility. Provides superior balance support.', TRUE,  TRUE,  30, 'StepSure'),
(7,  'Forearm Crutches (Pair)',         69.99, 4.6, 'Crutches',                  'crutches',                  'https://images.unsplash.com/photo-1584515933487-779824d29309?w=600&q=80', 'Premium forearm crutches with adjustable height and ergonomic hand grips. Designed for long-term comfort and reliable support during recovery.', FALSE, FALSE, 35, 'CrutchCare'),
(8,  'Underarm Crutches (Pair)',        44.99, 4.4, 'Crutches',                  'crutches',                  'https://images.unsplash.com/photo-1584515933487-779824d29309?w=600&q=80', 'Classic underarm crutches with padded tops and hand grips for comfortable temporary use during injury recovery.', FALSE, FALSE, 40, 'CrutchCare'),
(9,  'Premium Rollator Walker',        189.99, 4.8, 'Walkers & Rollators',       'walkers-rollators',         'https://images.unsplash.com/photo-1579684385127-1ef15d508118?w=600&q=80', 'Feature-rich rollator with padded seat, storage basket, and ergonomic brakes. Perfect for indoor and outdoor mobility with style and comfort.', FALSE, TRUE,  20, 'WalkEasy'),
(10, 'Folding Walker Frame',            79.99, 4.5, 'Walkers & Rollators',       'walkers-rollators',         'https://images.unsplash.com/photo-1579684385127-1ef15d508118?w=600&q=80', 'Sturdy folding walker with height adjustment and front wheels for easy gliding. Compact and travel-friendly design for daily use.', FALSE, FALSE, 28, 'WalkEasy'),
(11, 'Knee Scooter',                   229.99, 4.7, 'Mobility Aids',             'mobility-aids',             'https://images.unsplash.com/photo-1576765608535-5f04d1e3f289?w=600&q=80', 'Comfortable knee scooter for hands-free mobility during foot or ankle recovery. Features steerable design and dual brakes.', TRUE,  FALSE, 15, 'MobilityPro'),
(12, 'Transfer Board',                  49.99, 4.3, 'Mobility Aids',             'mobility-aids',             'https://images.unsplash.com/photo-1576765608535-5f04d1e3f289?w=600&q=80', 'Smooth glide transfer board for safe and easy transfers between wheelchair, bed, and car. Polished surface with tapered ends.', FALSE, FALSE, 22, 'SafeTransfer'),
(14, 'Knee Support Brace',              34.99, 4.5, 'Orthopedic Supports',       'orthopedic-supports',       'https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=600&q=80', 'Adjustable knee support brace with stabilizers for pain relief and injury prevention. Breathable fabric for all-day wear comfort.', FALSE, TRUE,  50, 'OrthoFlex'),
(15, 'Lumbar Back Brace',               49.99, 4.6, 'Orthopedic Supports',       'orthopedic-supports',       'https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=600&q=80', 'Medical-grade lumbar back brace with dual adjustment straps for targeted lower back support. Reduces pain and improves posture.', FALSE, FALSE, 38, 'OrthoFlex'),
(19, 'Memory Foam Wheelchair Cushion',  79.99, 4.8, 'Wheelchair Cushions',       'wheelchair-cushions',       'https://images.unsplash.com/photo-1586023492125-27b2c045efd7?w=600&q=80', 'Premium memory foam wheelchair cushion with gel layer for pressure relief. Removable, washable cover with non-slip bottom.', FALSE, TRUE,  30, 'ComfortPlus'),
(22, 'Adjustable Shower Chair',         89.99, 4.7, 'Bathroom Safety',           'bathroom-safety',           'https://images.unsplash.com/photo-1584622650111-993a426fbf0a?w=600&q=80', 'Height-adjustable shower chair with backrest and non-slip rubber feet. Aluminum frame for rust-free durability in wet environments.', FALSE, FALSE, 22, 'BathSafe'),
(26, 'Reacher Grabber Tool',            19.99, 4.4, 'Daily Living Aids',         'daily-living-aids',         'https://images.unsplash.com/photo-1628771065518-0d82f1938462?w=600&q=80', 'Foldable long-reach grabber tool for picking up items without bending or stretching. Magnetic tip and jaw grip for versatile use.', FALSE, FALSE, 65, 'EasyReach'),
(30, 'Smart Walking Stick',            149.99, 4.8, 'Smart Assistive Devices',   'smart-assistive-devices',   'https://images.unsplash.com/photo-1510017803434-a899398421b3?w=600&q=80', 'AI-powered smart walking stick with fall detection, GPS tracking, SOS alert button, and LED flashlight. Connects to smartphone app.', TRUE,  TRUE,  20, 'SmartAid'),
(34, 'Resistance Therapy Bands Set',    29.99, 4.6, 'Therapy & Rehabilitation',  'therapy-rehabilitation',    'https://images.unsplash.com/photo-1571019614242-c5c5dee9f50b?w=600&q=80', 'Set of 5 color-coded resistance therapy bands for physical therapy and rehabilitation exercises. Progressive resistance levels.', FALSE, FALSE, 45, 'RehabPro'),
(38, 'Digital Blood Pressure Monitor',  49.99, 4.7, 'Medical Monitoring Devices','medical-monitoring-devices','https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=600&q=80', 'Clinically validated digital blood pressure monitor with large LCD display, irregular heartbeat detection, and memory for 120 readings.', FALSE, TRUE,  40, 'HealthCheck');

-- -------------------------------------------------------
-- Product Images
-- -------------------------------------------------------
INSERT IGNORE INTO product_images (product_id, image_url, sort_order) VALUES
(1,  'https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=600&q=80', 0),
(1,  'https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=600&q=80', 1),
(2,  'https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=600&q=80', 0),
(2,  'https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=600&q=80', 1),
(3,  'https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=600&q=80', 0),
(3,  'https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=600&q=80', 1),
(4,  'https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=600&q=80', 0),
(4,  'https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=600&q=80', 1),
(5,  'https://images.unsplash.com/photo-1581579438747-1dc8d1e058c6?w=600&q=80', 0),
(5,  'https://images.unsplash.com/photo-1576765608535-5f04d1e3f289?w=600&q=80', 1),
(6,  'https://images.unsplash.com/photo-1581579438747-1dc8d1e058c6?w=600&q=80', 0),
(6,  'https://images.unsplash.com/photo-1576765608535-5f04d1e3f289?w=600&q=80', 1),
(7,  'https://images.unsplash.com/photo-1584515933487-779824d29309?w=600&q=80', 0),
(7,  'https://images.unsplash.com/photo-1581579438747-1dc8d1e058c6?w=600&q=80', 1),
(8,  'https://images.unsplash.com/photo-1584515933487-779824d29309?w=600&q=80', 0),
(8,  'https://images.unsplash.com/photo-1579684385127-1ef15d508118?w=600&q=80', 1),
(9,  'https://images.unsplash.com/photo-1579684385127-1ef15d508118?w=600&q=80', 0),
(9,  'https://images.unsplash.com/photo-1576765608535-5f04d1e3f289?w=600&q=80', 1),
(10, 'https://images.unsplash.com/photo-1579684385127-1ef15d508118?w=600&q=80', 0),
(10, 'https://images.unsplash.com/photo-1576765608535-5f04d1e3f289?w=600&q=80', 1),
(11, 'https://images.unsplash.com/photo-1576765608535-5f04d1e3f289?w=600&q=80', 0),
(11, 'https://images.unsplash.com/photo-1579684385127-1ef15d508118?w=600&q=80', 1),
(12, 'https://images.unsplash.com/photo-1576765608535-5f04d1e3f289?w=600&q=80', 0),
(12, 'https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=600&q=80', 1),
(14, 'https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=600&q=80', 0),
(14, 'https://images.unsplash.com/photo-1571019614242-c5c5dee9f50b?w=600&q=80', 1),
(15, 'https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=600&q=80', 0),
(15, 'https://images.unsplash.com/photo-1571019614242-c5c5dee9f50b?w=600&q=80', 1),
(19, 'https://images.unsplash.com/photo-1586023492125-27b2c045efd7?w=600&q=80', 0),
(19, 'https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=600&q=80', 1),
(22, 'https://images.unsplash.com/photo-1584622650111-993a426fbf0a?w=600&q=80', 0),
(22, 'https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=600&q=80', 1),
(26, 'https://images.unsplash.com/photo-1628771065518-0d82f1938462?w=600&q=80', 0),
(26, 'https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=600&q=80', 1),
(30, 'https://images.unsplash.com/photo-1510017803434-a899398421b3?w=600&q=80', 0),
(30, 'https://images.unsplash.com/photo-1581579438747-1dc8d1e058c6?w=600&q=80', 1),
(34, 'https://images.unsplash.com/photo-1571019614242-c5c5dee9f50b?w=600&q=80', 0),
(34, 'https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=600&q=80', 1),
(38, 'https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=600&q=80', 0),
(38, 'https://images.unsplash.com/photo-1510017803434-a899398421b3?w=600&q=80', 1);

-- -------------------------------------------------------
-- Product Features
-- -------------------------------------------------------
INSERT IGNORE INTO product_features (product_id, feature_text, sort_order) VALUES
(1,'Lightweight aluminum frame',0),(1,'Foldable design',1),(1,'Adjustable footrests',2),(1,'Padded armrests',3),(1,'Anti-tip wheels',4),
(2,'Joystick control',0),(2,'25km range battery',1),(2,'Adjustable speed',2),(2,'USB charging port',3),(2,'LED headlights',4),
(3,'Ultra-lightweight 8kg',0),(3,'Compact fold',1),(3,'Travel bag included',2),(3,'Quick-release wheels',3),(3,'Airline approved',4),
(4,'Cambered wheels',0),(4,'Rigid frame',1),(4,'Anti-tip casters',2),(4,'Quick-release axles',3),(4,'Adjustable backrest',4),
(5,'Adjustable height',0),(5,'Ergonomic grip',1),(5,'Non-slip tip',2),(5,'Lightweight aluminum',3),(5,'Wrist strap',4),
(6,'4-point base',0),(6,'Built-in LED light',1),(6,'Adjustable height',2),(6,'360 degree pivot',3),(6,'Ergonomic handle',4),
(7,'Ergonomic grips',0),(7,'Adjustable cuff',1),(7,'Shock-absorbing tips',2),(7,'Height adjustable',3),(7,'Lightweight',4),
(8,'Padded underarm cushion',0),(8,'Adjustable height',1),(8,'Non-skid tips',2),(8,'Push-button adjustment',3),(8,'Comfortable grips',4),
(9,'Built-in padded seat',0),(9,'Storage basket',1),(9,'Ergonomic brakes',2),(9,'8 inch all-terrain wheels',3),(9,'Foldable design',4),
(10,'Folding mechanism',0),(10,'Front swivel wheels',1),(10,'Height adjustable',2),(10,'Rubber grips',3),(10,'Lightweight frame',4),
(11,'Steerable design',0),(11,'Dual handbrakes',1),(11,'Padded knee platform',2),(11,'Height adjustable',3),(11,'Storage basket',4),
(12,'Polished surface',0),(12,'Tapered ends',1),(12,'Lightweight',2),(12,'High weight capacity',3),(12,'Carry handle',4),
(14,'Dual stabilizers',0),(14,'Adjustable straps',1),(14,'Breathable fabric',2),(14,'Anti-slip design',3),(14,'Open patella',4),
(15,'Dual adjustment',0),(15,'Removable lumbar pad',1),(15,'Breathable mesh',2),(15,'Stays in place',3),(15,'Unisex design',4),
(19,'Memory foam + gel',0),(19,'Pressure relief',1),(19,'Non-slip bottom',2),(19,'Washable cover',3),(19,'Contoured design',4),
(22,'Height adjustable',0),(22,'Non-slip rubber feet',1),(22,'Drainage holes',2),(22,'Back support',3),(22,'Tool-free assembly',4),
(26,'32-inch reach',0),(26,'Foldable design',1),(26,'Magnetic tip',2),(26,'Rotating jaw',3),(26,'Lightweight',4),
(30,'Fall detection',0),(30,'GPS tracking',1),(30,'SOS button',2),(30,'LED flashlight',3),(30,'Phone app connectivity',4),
(34,'5 resistance levels',0),(34,'Color coded',1),(34,'Latex-free',2),(34,'Carrying pouch',3),(34,'Exercise guide included',4),
(38,'Large LCD display',0),(38,'Irregular heartbeat detection',1),(38,'120 memory storage',2),(38,'Dual user mode',3),(38,'WHO indicator',4);

-- -------------------------------------------------------
-- Product Specifications
-- -------------------------------------------------------
INSERT IGNORE INTO product_specifications (product_id, spec_key, spec_value, sort_order) VALUES
(1,'Weight Capacity','120 kg',0),(1,'Frame Material','Aluminum',1),(1,'Seat Width','18 inches',2),(1,'Weight','14 kg',3),(1,'Folded Width','11 inches',4),
(2,'Weight Capacity','150 kg',0),(2,'Battery Life','25 km',1),(2,'Max Speed','8 km/h',2),(2,'Charging Time','6 hours',3),(2,'Motor','Dual 250W',4),
(3,'Weight Capacity','100 kg',0),(3,'Frame Material','Carbon fiber blend',1),(3,'Seat Width','17 inches',2),(3,'Weight','8 kg',3),(3,'Folded Size','24x14x10 inches',4),
(4,'Weight Capacity','100 kg',0),(4,'Frame Material','Titanium alloy',1),(4,'Seat Width','16 inches',2),(4,'Weight','7.5 kg',3),(4,'Wheel Size','26 inches',4),
(5,'Height Range','30-39 inches',0),(5,'Material','Aluminum',1),(5,'Handle','Soft foam',2),(5,'Weight','340g',3),(5,'Max Load','100 kg',4),
(6,'Base Type','Quad (4 prong)',0),(6,'Height Range','28-37 inches',1),(6,'Material','Steel',2),(6,'Weight','600g',3),(6,'Battery','AAA x 2',4),
(7,'Height Range','4ft6-6ft6',0),(7,'Material','Aircraft-grade aluminum',1),(7,'Grip','Anatomical',2),(7,'Weight per crutch','500g',3),(7,'Max Load','130 kg',4),
(8,'User Height','5ft2-5ft10',0),(8,'Material','Aluminum',1),(8,'Padding','Foam cushion',2),(8,'Weight per crutch','620g',3),(8,'Max Load','136 kg',4),
(9,'Weight Capacity','136 kg',0),(9,'Seat Height','22 inches',1),(9,'Width','24 inches',2),(9,'Weight','7.7 kg',3),(9,'Wheel Size','8 inches',4),
(10,'Weight Capacity','127 kg',0),(10,'Height Range','32-39 inches',1),(10,'Width','22 inches',2),(10,'Weight','3.2 kg',3),(10,'Material','Aluminum',4),
(11,'Weight Capacity','136 kg',0),(11,'Wheel Size','10 inches',1),(11,'Platform Height','18-22 inches',2),(11,'Weight','10 kg',3),(11,'Turning Radius','42 inches',4),
(12,'Length','30 inches',0),(12,'Width','8 inches',1),(12,'Material','Birch plywood',2),(12,'Weight Capacity','180 kg',3),(12,'Weight','1.4 kg',4),
(14,'Sizes','S, M, L, XL',0),(14,'Material','Neoprene blend',1),(14,'Closure','Velcro straps',2),(14,'Support Level','Moderate',3),(14,'Washable','Yes',4),
(15,'Waist Range','28-44 inches',0),(15,'Height','9 inches',1),(15,'Material','Elastic mesh',2),(15,'Support Stays','4 spring stays',3),(15,'Washable','Hand wash',4),
(19,'Size','18 x 16 x 3 inches',0),(19,'Material','Memory foam + cooling gel',1),(19,'Cover','Breathable mesh',2),(19,'Weight','1.2 kg',3),(19,'Max Load','120 kg',4),
(22,'Weight Capacity','150 kg',0),(22,'Seat Height','16-21 inches',1),(22,'Seat Width','19 inches',2),(22,'Material','Aluminum + PE',3),(22,'Weight','2.7 kg',4),
(26,'Length','32 inches',0),(26,'Grip Force','3 lbs',1),(26,'Material','Aluminum + ABS',2),(26,'Weight','200g',3),(26,'Folded Length','17 inches',4),
(30,'Battery Life','7 days',0),(30,'Connectivity','Bluetooth 5.0 + 4G',1),(30,'Charging','USB-C',2),(30,'Weight','420g',3),(30,'Water Rating','IPX5',4),
(34,'Set','5 bands',0),(34,'Lengths','5 feet each',1),(34,'Material','TPE (latex-free)',2),(34,'Levels','Extra light to extra heavy',3),(34,'Includes','Door anchor + guide',4),
(38,'Measurement','Oscillometric',0),(38,'Range','0-299 mmHg',1),(38,'Accuracy','+-3 mmHg',2),(38,'Cuff Size','22-42 cm',3),(38,'Power','4 x AA batteries',4);

-- -------------------------------------------------------
-- Sample User
-- -------------------------------------------------------
INSERT IGNORE INTO users (id, name, email, password, role) VALUES
(1, 'John Doe', 'john@example.com', 'password123', 'USER');

