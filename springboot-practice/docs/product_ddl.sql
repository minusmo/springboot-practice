-- springBootPractice ddl.sql
use scit;

create table product(
product_seq int primary key auto_increment,
name varchar(50) not null,
stock int not null default 0,
description varchar(200),
category varchar(50),
price int not null default 0,
creation_date timestamp default current_timestamp,
update_date timestamp,
constraint uq_name_product unique (name)
);

create table review(
review_seq int primary key auto_increment,
title varchar(200) not null,
content varchar(500) not null,
create_date timestamp default current_timestamp,
update_date timestamp,
product_seq int not null,
constraint fk_review_product_seq_product foreign key (product_seq) references product(product_seq)
);

insert into product(
name, stock, description, category, price) values (
'컨버스',10,'캐쥬얼슈즈','스니커즈',50000
);

INSERT INTO review (title, content, product_seq) VALUES
('최고의 제품입니다', '정말 만족스러운 사용 경험이었습니다. 품질이 매우 좋습니다.', 1),
('가격 대비 만족', '가격에 비해 성능이 좋아서 놀랐습니다. 추천합니다.', 1),
('평범한 제품', '기대했던 것보다는 평범했지만 나쁘지 않았습니다.', 1),
('배송이 빨라요', '주문 후 빠르게 배송되어 만족했습니다.', 1),
('친절한 서비스', '고객 지원팀이 매우 친절하고 도움을 주었습니다.', 1),
('디자인이 예뻐요', '심플한 디자인이 마음에 듭니다. 집 분위기와 잘 어울립니다.', 1),
('기능이 다양해요', '다양한 기능 덕분에 사용하기 정말 편리합니다.', 1),
('조립이 쉬워요', '조립 과정이 간단해서 바로 사용할 수 있었습니다.', 1),
('내구성이 좋아요', '오랫동안 사용할 수 있을 것 같아 기쁩니다.', 1),
('사용 설명서가 자세해요', '처음 사용하는 사람도 쉽게 이해할 수 있었습니다.', 1),
('아이들이 좋아해요', '아이들이 너무 좋아해서 뿌듯합니다.', 1),
('선물용으로 딱이에요', '친구에게 선물했는데 아주 만족해했습니다.', 1),
('소음이 적어요', '작동 중에도 소음이 거의 없어 편안합니다.', 1),
('에너지 절약', '전력 소모가 적어서 전기세 걱정이 덜 됩니다.', 1),
('사이즈가 적당해요', '공간을 차지하지 않아서 좋습니다.', 1),
('업그레이드된 기능', '기존 모델보다 훨씬 나아졌습니다.', 1),
('마감이 훌륭해요', '세세한 부분까지 신경 쓴 느낌이 납니다.', 1),
('색상이 다양해요', '취향에 맞는 색상을 고를 수 있어 좋았습니다.', 1),
('가벼워서 이동이 편리해요', '이동할 때 힘들지 않아서 편리합니다.', 1),
('알람 기능이 유용해요', '알람 기능 덕분에 일정을 더 잘 관리할 수 있습니다.', 1),
('아쉬운 점이 조금 있어요', '기능은 좋지만 몇 가지 아쉬운 점도 있었습니다.', 1),
('친구 추천으로 샀어요', '친구가 추천해줘서 구매했는데 만족스럽습니다.', 1),
('할인을 많이 받았어요', '할인된 가격으로 좋은 제품을 구매했어요.', 1),
('기대 이상이었습니다', '처음엔 반신반의했지만 기대 이상으로 좋았습니다.', 1),
('리뷰를 보고 구매했어요', '리뷰 평이 좋아서 구매했는데 실망하지 않았습니다.', 1);

commit;