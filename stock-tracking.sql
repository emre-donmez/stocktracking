	/*
	 Navicat Premium Data Transfer

	 Source Server         : Root
	 Source Server Type    : MySQL
	 Source Server Version : 100424
	 Source Host           : localhost:3306
	 Source Schema         : stoktakip

	 Target Server Type    : MySQL
	 Target Server Version : 100424
	 File Encoding         : 65001

	 Date: 23/06/2022 21:23:53
	*/

	SET NAMES utf8mb4;
	SET FOREIGN_KEY_CHECKS = 0;

	CREATE DATABASE `stocktracking`;
	USE stocktracking;
	-- ----------------------------
	-- Table structure for authorities
	-- ----------------------------
	DROP TABLE IF EXISTS `authorities`;
	CREATE TABLE `authorities`  (
	  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  `authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  UNIQUE INDEX `idx_auth_username`(`username` ASC, `authority` ASC) USING BTREE
	) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

	-- ----------------------------
	-- Records of authorities
	-- ----------------------------
	INSERT INTO `authorities` VALUES ('admin', 'ROLE_ADMIN');
	INSERT INTO `authorities` VALUES ('admin', 'ROLE_USER');
	INSERT INTO `authorities` VALUES ('user', 'ROLE_USER');

	-- ----------------------------
	-- Table structure for hibernate_sequence
	-- ----------------------------
	DROP TABLE IF EXISTS `hibernate_sequence`;
	CREATE TABLE `hibernate_sequence`  (
	  `next_val` bigint NULL DEFAULT NULL
	) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Fixed;

	-- ----------------------------
	-- Records of hibernate_sequence
	-- ----------------------------
	INSERT INTO `hibernate_sequence` VALUES (2);

	-- ----------------------------
	-- Table structure for customer
	-- ----------------------------
	DROP TABLE IF EXISTS `customer`;
	CREATE TABLE `customer`  (
	  `id` int NOT NULL AUTO_INCREMENT,
	  `company` varchar(45) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  `fax_number` varchar(45) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  PRIMARY KEY (`id`) USING BTREE
	) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

	-- ----------------------------
	-- Records of customer
	-- ----------------------------
	INSERT INTO `customer` VALUES (12, 'İnce Hesap', '0850 800 4623', '0212 555 1212', 'destek@incehesap.com', 'Taşdelen, Atabey Cd. No:9/1, 34788 Çekmeköy/İstanbul');
	INSERT INTO `customer` VALUES (21, 'Adeks', '0212 227 57 78', '0212 231 1353', 'destek@adeks.com', 'Cihannüma, Barbaros Blv. No:59, 34353 Beşiktaş/İstanbul');
	INSERT INTO `customer` VALUES (22, 'Teknosa', '0216 468 36 36', '0216 448 46 46', 'info@teknosa.com', 'Cevizli, Tugay Yolu Cd. No:67, 34846 Maltepe/İstanbul');

	-- ----------------------------
	-- Table structure for supplier
	-- ----------------------------
	DROP TABLE IF EXISTS `supplier`;
	CREATE TABLE `supplier`  (
	  `id` int NOT NULL AUTO_INCREMENT,
	  `company` varchar(45) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  `fax_number` varchar(45) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  PRIMARY KEY (`id`) USING BTREE
	) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

	-- ----------------------------
	-- Records of supplier
	-- ----------------------------
	INSERT INTO `supplier` VALUES (122, 'AMD Türkiye', '0850 800 4623', '0212 555 1212', 'destek@amd.com', 'Barbaros Palladium Tower Kat:10, Kardelen Sk. No:2, 34756 Ataşehir');
	INSERT INTO `supplier` VALUES (124, 'Asus Türkiye', '0850 522 2787', '0212 555 2342', 'destek@asus.com', 'Balgat, Ehlibeyt mh. Ceyhun Atıf Kansu cd. Ata Plaza No:100/23 K:8, 06520 Çankaya');
	INSERT INTO `supplier` VALUES (125, 'Lenovo', '0212 912 01 34', '0212 912 05 35', 'info@lenovo.com', 'Cevizli, Tugay Yolu Cd. No:67, 34846 Maltepe/İstanbul');
	INSERT INTO `supplier` VALUES (129, 'MSI', '0212 288 42 30', '6666', 'info-tr@msi.com', 'Gülbahar Cad. Cem Apt. No:17 Mecidiyeköy – Şişli / İstanbul');

	-- ----------------------------
	-- Table structure for product
	-- ----------------------------
	DROP TABLE IF EXISTS `product`;
	CREATE TABLE `product`  (
	  `barcode_id` int NOT NULL,
	  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  PRIMARY KEY (`barcode_id`) USING BTREE
	) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

	-- ----------------------------
	-- Records of product
	-- ----------------------------
	INSERT INTO `product` VALUES (12422342, 'AMD Ryzen 2200');
	INSERT INTO `product` VALUES (35533443, 'AMD Ryzen 5500');
	INSERT INTO `product` VALUES (124323432, 'Asus Prime B550-A Anakart');
	INSERT INTO `product` VALUES (345234523, 'Corsair 16 GB 3200 MHZ RAM');

	-- ----------------------------
	-- Table structure for stock_out
	-- ----------------------------
	DROP TABLE IF EXISTS `stock_out`;
	CREATE TABLE `stock_out`  (
	  `id` int NOT NULL AUTO_INCREMENT,
	  `barcode_id` int NULL DEFAULT NULL,
	  `customer_id` int NULL DEFAULT NULL,
	  `piece` int NULL DEFAULT NULL,
	  `price` bigint NULL DEFAULT NULL,
	  `release_date` date NULL DEFAULT NULL,
	  PRIMARY KEY (`id`) USING BTREE,
	  INDEX `barcode_id`(`barcode_id` ASC) USING BTREE,
	  INDEX `id`(`id` ASC) USING BTREE,
	  CONSTRAINT `stock_out_ibfk_1` FOREIGN KEY (`barcode_id`) REFERENCES `product` (`barcode_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
	  CONSTRAINT `stock_out_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
	) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

	-- ----------------------------
	-- Records of stock_out
	-- ----------------------------
	INSERT INTO `stock_out` VALUES (1, 12422342, 12, 100, 200000, '2022-05-11');
	INSERT INTO `stock_out` VALUES (7, 35533443, 12, 555551, 3331, '2022-06-11');
	INSERT INTO `stock_out` VALUES (14, 35533443, 22, 222, 10000, '2022-06-10');

	-- ----------------------------
	-- Table structure for stock_in
	-- ----------------------------
	DROP TABLE IF EXISTS `stock_in`;
	CREATE TABLE `stock_in`  (
	  `id` int NOT NULL AUTO_INCREMENT,
	  `barcode_id` int NULL DEFAULT NULL,
	  `supplier_id` int NULL DEFAULT NULL,
	  `piece` int NULL DEFAULT NULL,
	  `price` bigint NULL DEFAULT NULL,
	  `entry_date` date NULL DEFAULT NULL,
	  PRIMARY KEY (`id`) USING BTREE,
	  INDEX `barcode_id`(`barcode_id` ASC) USING BTREE,
	  INDEX `id`(`id` ASC) USING BTREE,
	  CONSTRAINT `stock_in_ibfk_1` FOREIGN KEY (`barcode_id`) REFERENCES `product` (`barcode_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
	  CONSTRAINT `stock_in_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
	) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

	-- ----------------------------
	-- Records of stock_in
	-- ----------------------------
	INSERT INTO `stock_in` VALUES (14, 12422342, 124, 300, 5234234, '2022-06-07');
	INSERT INTO `stock_in` VALUES (22, 12422342, 124, 32, 23, '2022-06-09');
	INSERT INTO `stock_in` VALUES (24, 124323432, 124, 4343, 4324324, '2022-06-21');

	-- ----------------------------
	-- Table structure for users
	-- ----------------------------
	DROP TABLE IF EXISTS `users`;
	CREATE TABLE `users`  (
	  `username` varchar(128) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
	  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
	  `enabled` bit(1) NULL DEFAULT NULL,
	  PRIMARY KEY (`username`) USING BTREE
	) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

	-- ----------------------------
	-- Records of users
	-- ----------------------------
	INSERT INTO `users` VALUES ('admin', '{bcrypt}$2a$12$dmvkVRFIWR3sP0AjURXKEOfP8eamWjlOpjuDszXv5ILjAVcK.LCji', b'1');
	INSERT INTO `users` VALUES ('editor', '{bcrypt}$2a$12$l2xmhgKhxBAzkn83AvKPoOTjCJj1BhkalWGDZv.Xayg.km8ogDaYm', b'1');
	INSERT INTO `users` VALUES ('user', '{bcrypt}$2a$12$Wcx73K0b485NMk.s.gPc5Ou/M7xy5OllLMgNPe209KLITFOE4hbvq', b'1');

	-- ----------------------------
	-- View structure for stock_status
	-- ----------------------------
	DROP VIEW IF EXISTS `stock_status`;
	CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `stock_status` AS SELECT product.barcode_id,product.name,COALESCE(SUM(stock_in.piece),0)-COALESCE(SUM(stock_out.piece),0) as piece, ROUND(COALESCE(COALESCE(SUM(stock_in.price),0)/COALESCE(SUM(stock_in.piece),0),0),2) as average_cost FROM product LEFT JOIN stock_in ON stock_in.barcode_id = product.barcode_id LEFT JOIN stock_out ON stock_in.barcode_id=stock_out.barcode_id GROUP BY product.barcode_id ORDER BY piece DESC ;

	SET FOREIGN_KEY_CHECKS = 1;
