/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cover_generator;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Ian
 */
public class QuestsTable {
	private ArrayList<Quest> QuestsList = new ArrayList<Quest>();
	Object[][] tableData = {};
	JTable table ;
	HashMap<Integer, Object[]> tableMap= new HashMap<Integer, Object[]>();
	
    public QuestsTable(){
    	
    	this.table = new JTable(new DefaultTableModel(tableData, new Object[]{"no", "Course code", "Parts","QR code","Status" }));

    }
    
    public void addQuest(Quest q){
    	this.QuestsList.add(q);
    	System.out.println(q.getClassCode());
    	Object[] newRow = new Object[]{q.id,q.getClassCode(),q.getPartNum(),q.QR,"Waiting..."};
    	((DefaultTableModel) this.table.getModel()).addRow(newRow);
    	tableMap.put(q.id, newRow);
    }
    
    
    public void finishQuest(Quest q){
    	q.done = true;
    	((DefaultTableModel) this.table.getModel()).setValueAt("[Done]", q.id-1, 4);
    }
    
    public void failQuest(Quest q){
    	((DefaultTableModel) this.table.getModel()).setValueAt("Fail.", q.id-1, 4);
    }
    
    

    public ArrayList<Quest> getQuestsList() {
            return QuestsList;
    }

    public void setQuestsList(ArrayList<Quest> questsList) {
            QuestsList = questsList;
    }

	public Object[][] getTableData() {
		return tableData;
	}

	public void setTableData(Object[][] tableData) {
		this.tableData = tableData;
	}


	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

    

    
}
