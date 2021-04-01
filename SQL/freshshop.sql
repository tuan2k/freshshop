-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2021 at 02:40 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `freshshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `counter` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`id`, `order_id`, `user_id`, `product_id`, `counter`) VALUES
(213, 64, 6, 5, 1),
(214, 64, 6, 6, 1),
(215, 64, 6, 7, 1),
(216, 64, 6, 8, 1),
(217, 66, 6, 5, 1),
(218, 66, 6, 6, 1),
(219, 66, 6, 7, 2),
(220, 66, 6, 8, 1),
(221, 78, 6, 5, 3),
(222, 78, 6, 6, 4),
(223, 79, 6, 5, 1),
(224, 79, 6, 6, 1),
(225, 79, 6, 7, 0),
(226, 89, 6, 5, 2),
(228, 89, 6, 5, 2),
(229, 89, 6, 6, 2),
(230, 90, 2, 5, 2),
(231, 90, 2, 6, 2),
(232, 90, 2, 7, 2),
(233, 91, 9, 5, 2),
(234, 91, 9, 6, 1),
(235, 91, 9, 7, 1),
(236, 92, 10, 5, 2),
(237, 92, 10, 6, 1),
(238, 92, 10, 10, 3),
(241, 94, 7, 5, 3),
(242, 95, 7, 5, 3),
(243, 95, 7, 6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'rau'),
(2, 'củ'),
(3, 'Quả'),
(4, 'Sữa');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `total`, `date`, `status`) VALUES
(89, 6, 80, '2021-03-05 14:10:40', 1),
(90, 2, 100, '2021-04-06 13:54:49', 0),
(91, 9, 60, '2021-04-07 04:38:46', 0),
(92, 10, 70, '2021-03-07 04:39:44', 0),
(95, 7, 50, '2021-03-07 12:45:51', 0);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `price` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `number` int(11) NOT NULL,
  `preview` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `image`, `price`, `number`, `preview`, `cat_id`) VALUES
(5, 'Cà chua', 'img-pro-02.jpg', '10', 100, 'Đây là cà chua số 1 thế giới. Được sản xuất và nuôi trồng bởi chuyên gia Nguyễn Thanh Tuấn dưới công nghệ hiện đại trong nhiều năm liền. Mỗi năm chỉ ra 10 quả duy nhất.', 3),
(6, 'Cà rốt', 'img-pro-02.jpg', '20', 10000, 'Củ cà rốt này lần đầu được tìm thấy ở mặt trăng và dược anh Nguyễn Thanh Tuấn đem về trái đất trồng. Mỗi năm chỉ ra 1 củ duy nhất.', 2),
(7, 'Nho Bình Thuận', 'img-pro-02.jpg', '20', 10000, 'Nho xanh Bình Thuận là loại nho nổi tiếng ở nước ta. Được phân bố và buôn bán rộng khắp nước với chất lượng được đảm bảo', 3),
(8, 'Táo Campuchia', 'img-pro-02.jpg', '17', 10000, 'Táo Campuchia là loại táo được trồng ở campuchia. Loại táo này khi ăn rất tốt cho sức khỏe và cũng rất hiếm.Bởi vì loại táo này được trồng ở nhiệt độ khắc ghiệt nhất.', 3),
(10, 'Tiêu xanh', 'img-pro-03.jpg', '10', 100000, 'Đây là loại tiêu có một không hai nhé.', 3),
(11, 'Đu đủ Mỹ', 'img-pro-04.jpg', '25', 100000, 'Đu đủ với chuyển giao từ Mỹ ngon ngọt', 3),
(12, 'Đu đủ Việt Nam', 'img-pro-04.jpg', '35', 100000, 'Đu đủ Việt với chât lượng đỉnh cao', 3),
(13, 'Cà rốt Đà Lạt', 'img-pro-01.jpg', '12', 100000, 'Cà rốt Việt với chất lượng cao hơn nè.', 2),
(14, 'Tiêu xanh Đà Nẵng', 'img-pro-03.jpg', '7', 100000, 'Tiêu xanh chất lượng cao.', 1),
(15, 'Cà rốt Mỹ ', 'img-pro-01.jpg', '7', 100000, 'Đây là cà rốt được nuôi cấy và trồng ở Mỹ với chất lượng rất cao.', 2);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `role_id` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `fullname`, `role_id`, `address`, `phone`, `gender`) VALUES
(1, 'admin', '123', 'Nguyễn Thanh Tuấn', 1, '23/17 ngo si lien ', '0766767006', 'Nam'),
(2, 'volekhanh', '123', 'Võ Lê Khanh', 2, '123 Vo Le Khanh', '0766767006', 'Nu'),
(6, 'volekhanhheo', '123', 'khanh heo', 2, '123 Vo Le Khanh heo', '123', 'Nu'),
(7, 'thanhtuan', '123', 'tuan dep trai1', 2, '123 Vo Le Khanh', '123', 'Nam'),
(9, 'user1', '123', 'tuan dep trai 2000', 2, '23/17 ngo si lien test', '123456789', 'Nam'),
(10, 'user2', '123', 'tuan dep trai', 2, '123 Vo Le Khanh', '115', 'Nam'),
(12, 'user3', '123', 'Nguyễn Thanh Tuấn', 2, '123 Vo Le Khanh', '0766767006', 'Nam');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`user_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cat_id` (`cat_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=244;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=96;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`cat_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
