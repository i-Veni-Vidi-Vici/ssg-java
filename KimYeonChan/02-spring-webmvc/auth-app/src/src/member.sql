drop table tbl_member;

-- 회원 테이블 생성
CREATE TABLE tbl_member (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            username VARCHAR(50) NOT NULL UNIQUE,
                            password VARCHAR(255) NOT NULL,
                            name VARCHAR(50) NOT NULL,
                            email VARCHAR(100) NOT NULL UNIQUE,
                            createdAt DATETIME NOT NULL
);

-- 샘플 데이터 삽입
INSERT INTO tbl_member (username, password, name, email, createdAt) VALUES
                                                                        ('chulsoo123', 'password1', '김철수', 'chulsoo.kim@example.com', '2023-01-15 10:30:00'),
                                                                        ('younghee456', 'password2', '이영희', 'younghee.lee@example.com', '2023-02-20 14:45:00'),
                                                                        ('minsoo789', 'password3', '박민수', 'minsoo.park@example.com', '2023-03-05 08:20:00'),
                                                                        ('jieun012', 'password4', '최지은', 'jieun.choi@example.com', '2023-04-12 09:15:00'),
                                                                        ('hyunwoo345', 'password5', '정현우', 'hyunwoo.jung@example.com', '2023-05-18 17:50:00');

-- 테이블 내용 확인
SELECT * FROM tbl_member;