select * from tbl_member;
select * from tbl_authority;
alter table tbl_authority rename column authorties to authorities;

insert into
    tbl_member(member_id, password, name)
values
    ('honggd', '$2a$12$ft4qmUFSwkvj8okVs4GvUeToSwnovqpR9nJPL19dd6dGx.i0qD7ma', '홍길동'),
    ('sinsa', '$2a$12$ft4qmUFSwkvj8okVs4GvUeToSwnovqpR9nJPL19dd6dGx.i0qD7ma', '신사임당');

insert into
    tbl_authority(member_id, authorities)
values
    ('honggd', 'ROLE_USER'),
    ('sinsa', 'ROLE_USER'),
    ('sinsa', 'ROLE_ADMIN');
