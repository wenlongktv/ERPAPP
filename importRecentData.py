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
	excelData = readCollegeAttributeFromExcel(11)
	updateAttributeForCollege('updated_column_name', excelData, 'src_column_excel')

def readCollegeAttributeFromExcel(column_count):
	data = xlrd.open_workbook('test.xlsx') # 打开xls文件
	sheet = data.sheets()[0]
	print (sheet.name)
	nrows = sheet.nrows
	
	headers=sheet.row_values(0)[:column_count]
	data=[]
	for rownum in range(nrows):
		if rownum == 0:
			continue
		data.append(sheet.row_values(rownum)[:column_count])
	
	excelData = {"headers":headers, "data":data}
	return excelData
		
		

def updateAttributeForCollege(updated_column_name, excelData, src_column_excel):
	src_excel_headers = ['major_type', 'batch', 'collegue_name']
	if ('major_type' not in excelData['headers']) | ('batch' not in excelData['headers']) | ('collegue_name' not in excelData['headers']):
		print('basic header not much')
		return

	sql="update tb_collegue_statistic set " +updated_column_name+" = ? where major_type = ? AND batch=? AND collegue_name = ?"
	#DbHelper.updateBatch(sql, )

#start application
importRecentCollege()
