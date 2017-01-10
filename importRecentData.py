#coding=utf-8
import xlrd
import DbHelper

# data = xlrd.open_workbook('test.xlsx') # 打开xls文件
# table = data.sheets()[0] # 打开第一张表
# nrows = table.nrows # 获取表的行数
# for i in range(nrows): # 循环逐行打印
	# if i == 0: # 跳过第一行
		# continue
	
	# #取前十三列
	# print (table.row_values(i)[:13])

def loadDB():
	sql = "select * from sys_user";
	result = DbHelper.query(sql)
	print(result)
	return

def importRecentCollege():
	data = xlrd.open_workbook('test.xlsx') # 打开xls文件
	sheets = data.sheets()
	
	for sheet in sheets:
		if not sheet.name.isdigit():
			continue
		print (sheet.name)
		nrows = sheet.nrows 
		for i in range(nrows): # 循环逐行打印
			print (sheet.row_values(i)[:13]) # 取前十三列

	
#loadDB()
importRecentCollege()

def updateAttributeForCollege(column_name):
	src_excel_headers = ['major_type', 'batch', 'school_name']
	updatedcolumn_in_db = ""
	
	
