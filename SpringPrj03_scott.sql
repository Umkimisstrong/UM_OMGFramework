SELECT USER
FROM DUAL;
--==>> SCOTT


SELECT *
FROM TBL_MEMBERLIST;


-- �� ���̺� ����
CREATE TABLE TBL_MEMBERLIST
( ID        VARCHAR2(30)    NOT NULL
, PW        VARCHAR2(50)    NOT NULL
, NAME      VARCHAR2(50)    NOT NULL
, TEL       VARCHAR2(50)    NOT NULL
, EMAIL     VARCHAR2(100)   
, CONSTRAINT MEMBERLIST_ID_PK PRIMARY KEY(ID)
);
--==>> Table TBL_MEMBERLIST��(��) �����Ǿ����ϴ�.

-- �� ������ �Է�(��ȣȭ ��Ű�� ���)
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL)
VALUES('admin', CRYPTPACK.ENCRYPT('JAVA006$', 'admin'), '������', '010-1234-1234', 'admin@test.com');
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

-- �� ���� ����
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL) VALUES('admin', CRYPTPACK.ENCRYPT('java006$', 'admin'), '������', '010-1234-1234', 'admin@test.com')
;


-- �� Ȯ��
SELECT *
FROM TBL_MEMBERLIST;
--==>> admin	?(C??	������	010-1234-1234	admin@test.com

-- �� Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�.

-- �� �⺻ ��ȸ ������ ����
SELECT ID, NAME, TEL, EMAIL
FROM TBL_MEMBERLIST;
--> �� �� ����

SELECT ID, NAME, TEL, EMAIL FROM TBL_MEMBERLIST
;
--==>> admin	������	010-1234-1234	admin@test.com


-- �� ������ �߰� �Է�(���� ���� �ǽ��� ���� �غ� - ���� ȯ�� ����)
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL) 
VALUES('kimsangki', CRYPTPACK.ENCRYPT('java006$', 'admin'), '����', '010-5693-4223', 'kim@test.com')
;

-- �� ��ȸ
SELECT ID, NAME, TEL, EMAIL FROM TBL_MEMBERLIST
;
/*
admin	������	010-1234-1234	admin@test.com
kimsangki	����	010-5693-4223	kim@test.com
*/

-- �� Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�.



