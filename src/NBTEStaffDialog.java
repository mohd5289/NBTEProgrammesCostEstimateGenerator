import java.util.ArrayList;
import java.util.Arrays;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NBTEStaffDialog {

	public NBTEStaffDialog(ProgrammesCostEstimates main, ObservableList<Object> personnelList, String visit, Button enableSubmitBtn, ObservableList<SimpleIntegerProperty> divisionSizes) {
		
		// TODO Auto-generated constructor stub
	
//String typeOfVisit = visit.getValue();
		
		Stage subStage = new Stage();
		
		 subStage.setTitle("Add NBTE Staff");
        subStage.initModality(Modality.APPLICATION_MODAL);

		
		GridPane pane = new GridPane();
		 pane.setAlignment(Pos.CENTER);
		 pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		 pane.setHgap(5.5);
		 pane.setVgap(5.5);
		
		 ComboBox<String> ranks = new ComboBox<>();
		
		 ranks.setPrefWidth(200);
		 ranks.setValue("Chief and Above");
		  ObservableList<String> items =FXCollections.observableArrayList(new ArrayList<String>(
		            Arrays.asList("Chief and Above","Asst Chief and Below")));
		  ranks.getItems().addAll(items);
		 // Place nodes in the pane
		  
		 TextField nameOfOfficer = new TextField();
		  
		 pane.add(new Label("NBTE Staff Name:"), 0, 0);
		 pane.add(nameOfOfficer, 1, 0);
		 pane.add(new Label("Rank of Officer:"), 0, 1);
		 pane.add(ranks, 1, 1);
		 
		 
		 Button btAddNBTEStaff = new Button("Add NBTE Staff");
		
		 btAddNBTEStaff.setOnAction((ActionEvent e) ->{
				
			 String officerName = nameOfOfficer.getText();
			boolean isSeniorStaff = ranks.getValue()== "Chief and Above"?true:false;
			 
			personnelList.add(new NBTEStaff(officerName,isSeniorStaff,visit));
			
			 
			if(ProgrammesCostEstimates.genCostEstimateBtnClicked==false) {
				enableSubmitBtn.setVisible(true);
	        	}
					
					 subStage.close();
		 });
		 
			 pane.add(btAddNBTEStaff, 1, 2); 
		 
		
		 
		 
		 GridPane.setHalignment(btAddNBTEStaff, HPos.RIGHT);
		
		 
		 Scene scene = new Scene(pane);
		  // Set the stage title
		  subStage.setScene(scene); // Place the scene in the stage
		  subStage.show();
	
	}
public NBTEStaffDialog( ObservableList<Object> personnelList, int index, NBTEStaff nbteStaff) {
		
		// TODO Auto-generated constructor stub
	
String typeOfVisit = nbteStaff.getVisitationExercise();
		
		Stage subStage = new Stage();
		
		 subStage.setTitle("Add NBTE Staff");
        subStage.initModality(Modality.APPLICATION_MODAL);

		
		GridPane pane = new GridPane();
		 pane.setAlignment(Pos.CENTER);
		 pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		 pane.setHgap(5.5);
		 pane.setVgap(5.5);
		
		 ComboBox<String> ranks = new ComboBox<>();
		
		 ranks.setPrefWidth(200);
		 ranks.setValue(nbteStaff.isSeniorStaff()?"Chief and Above":"Asst Chief and Below");
		  ObservableList<String> items =FXCollections.observableArrayList(new ArrayList<String>(
		            Arrays.asList("Chief and Above","Asst Chief and Below")));
		  ranks.getItems().addAll(items);
		 // Place nodes in the pane
		  
		 TextField nameOfOfficer = new TextField(nbteStaff.getName());
		  
		 pane.add(new Label("NBTE Staff Name:"), 0, 0);
		 pane.add(nameOfOfficer, 1, 0);
		 pane.add(new Label("Rank of Officer:"), 0, 1);
		 pane.add(ranks, 1, 1);
		 
		 
		 Button btAddNBTEStaff = new Button("Add NBTE Staff");
		
		 btAddNBTEStaff.setOnAction((ActionEvent e) ->{
			
			 personnelList.remove(index);
			 String officerName = nameOfOfficer.getText();
			boolean isSeniorStaff = ranks.getValue()== "Chief and Above"?true:false;
			 
			personnelList.add(index,new NBTEStaff(officerName,isSeniorStaff,typeOfVisit));
			 subStage.close();
		 });
		 
			 pane.add(btAddNBTEStaff, 1, 2); 
		 
		
		 
		 
		 GridPane.setHalignment(btAddNBTEStaff, HPos.RIGHT);
		
		 
		 Scene scene = new Scene(pane);
		  // Set the stage title
		  subStage.setScene(scene); // Place the scene in the stage
		  subStage.show();
	
	}




}
