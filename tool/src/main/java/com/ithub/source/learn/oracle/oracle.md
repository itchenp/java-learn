#### sequence
    CREATE SEQUENCE seq_name MINVALUE 1 NOMAXVALUE INCREMENT BY 1 CACHE 2;

#### 查找相关表
    select a.COLUMN_NAME,a.DATA_TYPE,a.TABLE_NAME  from user_tab_columns  where a.user_tab_columns like '%字段名%';

#### Oracle 分组排序取第一条
    select r.user_id,r.user_name,r.user_age,r.least_time
    from (select t.user_id,t.user_name,t.user_age,t.least_time,
        row_number() over(partition by t.user_id order by t.least_time )rn
        from t_user_login t
        where t.status=0)r
    where r.rn=1

#### oracle 执行计划
    1. explain plan for +目标 SQL
    2. 下面四种选择执行一种  
      - select * from table(dbms_xplan.display);
      - select * from table(dbms_xplan.display_cursor(null,null,'advanced'));
      - select * from table(dbms_xplan.display_cursor('sql_id/hash value',child_cursor_number,'advanced'));
      - select * from table(dbms_xplan.display_awr('sql_id'));


