#coding=utf-8
#导入pymysql的包
import  pymysql
import  pymysql.cursors

#获取一个数据库连接，注意如果是UTF-8类型的，需要制定数据库
#port 必须是数字不能为字符串
connection=pymysql.connect(host='localhost',
                           user='root',
                           password='123456',
                           db='db_cyjy',
                           port=3306,
                           charset='utf8')

def query(sql):
	resutLit=[]
	try:
		with connection.cursor(pymysql.cursors.DictCursor) as cursor:
			with connection.cursor(pymysql.cursors.DictCursor) as cursor:
				cout=cursor.execute(sql)
				print("exec query:\n "+sql)
				print("query result： "+str(cout))
			
				for row in cursor.fetchall():
					#print("ID: "+str(row['id']) +"")
					resutLit.append(row)
			
			connection.commit();
	finally:
		connection.close()
	return resutLit;
	


def updateBatch(sql, paramsList):
	try:
		with connection.cursor(pymysql.cursors.DictCursor) as cursor:
			cursor = connection.cursor()
			for params in paramsList:
				cursor.execute(sql, paramsList)
			connection.commit();
	finally:
		cursor.close()
		connection.close()
