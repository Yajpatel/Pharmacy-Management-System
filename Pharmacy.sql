CREATE TABLE pharmacy (
  sr_no INT NOT NULL AUTO_INCREMENT, -- Serial number, primary key
  name VARCHAR(30) DEFAULT NULL, -- Name of the medication
  category VARCHAR(20) DEFAULT NULL, -- Category of the medication
  exp_date DATE DEFAULT NULL, -- Expiry date of the medication
  quantity INT DEFAULT NULL, -- Quantity in stock
  price DECIMAL(10,2) DEFAULT NULL, -- Price per unit
  PRIMARY KEY (sr_no) -- Set primary key here
);

INSERT INTO pharmacy(sr_no, name, category, exp_date, quantity, price) VALUES
(1, 'Aspirin', 'Painkiller', '2025-01-15', 50, 5.00),
(2, 'Ibuprofen', 'Painkiller', '2024-12-20', 100, 8.50),
(3, 'Amoxicillin', 'Antibiotic', '2025-06-25', 200, 12.00),
(4, 'Cetirizine', 'Antihistamine', '2024-11-30', 150, 4.50),
(5, 'Loratadine', 'Antihistamine', '2025-04-10', 120, 6.00),
(6, 'Metformin', 'Antidiabetic', '2024-08-15', 75, 10.00),
(7, 'Glipizide', 'Antidiabetic', '2025-02-22', 90, 7.50),
(8, 'Metoprolol', 'Antihypertensive', '2024-10-05', 200, 9.00),
(9, 'Lisinopril', 'Antihypertensive', '2025-03-14', 180, 8.00),
(10, 'Simvastatin', 'Cholesterol', '2024-12-01', 170, 15.00),
(11, 'Atorvastatin', 'Cholesterol', '2025-05-18', 160, 14.00),
(12, 'Levothyroxine', 'Hormone', '2024-09-25', 140, 11.00),
(13, 'Omeprazole', 'Antacid', '2025-02-10', 130, 13.00),
(14, 'Esomeprazole', 'Antacid', '2025-07-08', 120, 14.50),
(15, 'Pantoprazole', 'Antacid', '2024-11-11', 200, 9.50),
(16, 'Ranitidine', 'Antacid', '2025-03-05', 190, 10.50),
(17, 'Clopidogrel', 'Antiplatelet', '2024-10-20', 80, 12.00),
(18, 'Warfarin', 'Anticoagulant', '2025-01-30', 70, 14.00),
(19, 'Heparin', 'Anticoagulant', '2024-12-25', 50, 18.00),
(20, 'Furosemide', 'Diuretic', '2025-02-15', 90, 8.50),
(21, 'Spironolactone', 'Diuretic', '2024-11-20', 100, 10.00),
(22, 'Hydrochlorothiazide', 'Diuretic', '2025-04-18', 60, 7.00),
(23, 'Digoxin', 'Cardiac', '2024-08-30', 70, 15.00),
(24, 'Nitroglycerin', 'Cardiac', '2025-06-05', 80, 12.50),
(25, 'Isosorbide Mononitrate', 'Cardiac', '2024-09-15', 90, 14.50),
(26, 'Albuterol', 'Bronchodilator', '2025-01-20', 200, 18.00),
(27, 'Salmeterol', 'Bronchodilator', '2024-11-10', 150, 20.00),
(28, 'Formoterol', 'Bronchodilator', '2025-05-15', 120, 19.00),
(29, 'Fluticasone', 'Corticosteroid', '2024-10-05', 100, 25.00),
(30, 'Prednisone', 'Corticosteroid', '2025-03-10', 90, 22.00),
(31, 'Dexamethasone', 'Corticosteroid', '2024-12-12', 80, 23.00),
(32, 'Insulin', 'Antidiabetic', '2025-04-05', 75, 35.00),
(33, 'Gliclazide', 'Antidiabetic', '2024-11-15', 65, 12.00),
(34, 'Rosiglitazone', 'Antidiabetic', '2025-03-25', 70, 15.50),
(35, 'Glimepiride', 'Antidiabetic', '2024-10-20', 85, 14.00),
(36, 'Ciprofloxacin', 'Antibiotic', '2025-01-10', 200, 10.00),
(37, 'Levofloxacin', 'Antibiotic', '2024-12-18', 190, 9.50),
(38, 'Azithromycin', 'Antibiotic', '2025-04-22', 180, 12.50),
(39, 'Doxycycline', 'Antibiotic', '2024-09-10', 170, 11.00),
(40, 'Clindamycin', 'Antibiotic', '2025-02-25', 160, 13.00),
(41, 'Cephalexin', 'Antibiotic', '2024-08-20', 150, 14.50),
(42, 'Vancomycin', 'Antibiotic', '2025-05-30', 140, 25.00),
(43, 'Tetracycline', 'Antibiotic', '2024-11-11', 130, 22.00),
(44, 'Linezolid', 'Antibiotic', '2025-03-15', 120, 24.00),
(45, 'Benzonatate', 'Cough Suppressant', '2024-10-01', 110, 8.00),
(46, 'Guaifenesin', 'Expectorant', '2025-01-18', 200, 7.50),
(47, 'Dextromethorphan', 'Cough Suppressant', '2024-11-21', 100, 6.00),
(48, 'Hydroxyzine', 'Antihistamine', '2025-02-08', 180, 5.50),
(49, 'Montelukast', 'Antiasthmatic', '2024-12-02', 170, 15.00),
(50, 'Methylprednisolone', 'Corticosteroid', '2025-04-10', 160, 18.00),
(51, 'Triamcinolone', 'Corticosteroid', '2024-09-25', 150, 20.00),
(52, 'Budesonide', 'Corticosteroid', '2025-03-18', 140, 21.00),
(53, 'Ciclesonide', 'Corticosteroid', '2024-10-28', 130, 23.00),
(54, 'Betamethasone', 'Corticosteroid', '2025-01-11', 120, 22.50),
(55, 'Fluticasone', 'Corticosteroid', '2024-11-15', 110, 25.00),
(56, 'Mometasone', 'Corticosteroid', '2025-04-05', 100, 24.00),
(57, 'Hydrocortisone', 'Corticosteroid', '2024-12-05', 90, 22.00),
(58, 'Alendronate', 'Osteoporosis', '2025-03-12', 80, 18.50),
(59, 'Risedronate', 'Osteoporosis', '2024-09-20', 70, 19.50),
(60, 'Ibandronate', 'Osteoporosis', '2025-05-25', 60, 21.00),
(61, 'Zoledronic Acid', 'Osteoporosis', '2024-10-15', 50, 30.00),
(62, 'Denosumab', 'Osteoporosis', '2025-01-05', 40, 35.00),
(63, 'Raloxifene', 'Osteoporosis', '2024-11-20', 30, 25.00),
(64, 'Teriparatide', 'Osteoporosis', '2025-03-28', 20, 50.00),
(65, 'Bisoprolol', 'Antihypertensive', '2024-10-10', 90, 12.00),
(66, 'Carvedilol', 'Antihypertensive', '2025-01-22', 80, 14.00),
(67, 'Nebivolol', 'Antihypertensive', '2024-11-30', 70, 15.00),
(68, 'Atenolol', 'Antihypertensive', '2025-03-11', 60, 10.00),
(69, 'Propranolol', 'Antihypertensive', '2024-12-18', 50, 11.00),
(70, 'Enalapril', 'Antihypertensive', '2025-04-20', 40, 8.00),
(71, 'Ramipril', 'Antihypertensive', '2024-09-22', 30, 9.00),
(72, 'Losartan', 'Antihypertensive', '2025-05-12', 20, 7.00),
(73, 'Valsartan', 'Antihypertensive', '2024-10-25', 25, 8.50),
(74, 'Olmesartan', 'Antihypertensive', '2025-01-10', 35, 10.00),
(75, 'Telmisartan', 'Antihypertensive', '2024-11-15', 45, 12.50),
(76, 'Irbesartan', 'Antihypertensive', '2025-04-05', 55, 13.00),
(77, 'Hydralazine', 'Antihypertensive', '2024-12-25', 65, 15.00),
(78, 'Isosorbide Dinitrate', 'Cardiac', '2025-03-15', 75, 18.00),
(79, 'Amlodipine', 'Antihypertensive', '2024-11-05', 85, 20.00),
(80, 'Nifedipine', 'Antihypertensive', '2025-05-20', 95, 22.00),
(81, 'Diltiazem', 'Antihypertensive', '2024-10-15', 105, 24.00),
(82, 'Verapamil', 'Antihypertensive', '2025-01-20', 115, 25.00),
(83, 'Clonidine', 'Antihypertensive', '2024-12-10', 125, 30.00),
(84, 'Methyldopa', 'Antihypertensive', '2025-03-05', 135, 32.00),
(85, 'Captopril', 'Antihypertensive', '2024-09-25', 145, 15.00),
(86, 'Fosinopril', 'Antihypertensive', '2025-04-18', 155, 18.00),
(87, 'Quinapril', 'Antihypertensive', '2024-11-30', 165, 20.00),
(88, 'Perindopril', 'Antihypertensive', '2025-05-10', 175, 22.00),
(89, 'Trandolapril', 'Antihypertensive', '2024-10-25', 185, 25.00),
(90, 'Benazepril', 'Antihypertensive', '2025-01-05', 195, 27.00),
(91, 'Moexipril', 'Antihypertensive', '2024-12-20', 205, 28.00),
(92, 'Zofenopril', 'Antihypertensive', '2025-03-25', 215, 30.00),
(93, 'Labetalol', 'Antihypertensive', '2024-11-10', 225, 32.00),
(94, 'Prazosin', 'Antihypertensive', '2025-01-15', 235, 33.00),
(95, 'Doxazosin', 'Antihypertensive', '2024-09-20', 245, 35.00),
(96, 'Terazosin', 'Antihypertensive', '2025-04-05', 255, 36.00),
(97, 'Tamsulosin', 'Prostate', '2024-12-01', 265, 38.00),
(98, 'Alfuzosin', 'Prostate', '2025-03-22', 275, 40.00),
(99, 'Silodosin', 'Prostate', '2024-10-05', 285, 42.00),
(100, 'Dutasteride', 'Prostate', '2025-01-30', 295, 45.00);

