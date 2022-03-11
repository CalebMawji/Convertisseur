package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SampleController implements Initializable{

    @FXML
    private TabPane MonPane;
	
	@FXML
    private Tab tabAccueil;

    @FXML
    private Button HomeLongeur;
    
  //  @FXML
   // void ouvrirLonguer() {
   // 	TabPane.getsele().select(1);
  //  }
    
    @FXML
    private Button HomeTemps;
    
    @FXML
    private Button HomeMasse;
    
    @FXML
    void changer(ActionEvent e)
    {
    		Button b=(Button)e.getSource();
    		String a=b.getText();
    
    
    switch (a)
    
    {
    case "Longeur":
    	MonPane.getSelectionModel().select(1);
    	break;
    case "Masse":
    	MonPane.getSelectionModel().select(2);
    	break;
    case "Temps":
    	MonPane.getSelectionModel().select(3);
    	break;
    	}
    }
    
    @FXML
    void quitter()
    {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("SORTIE");
     alert.setContentText("Do you want to close this application ?");
     Optional<ButtonType> result=alert.showAndWait();
     if(result.get()==ButtonType.OK)
   	  System.exit(0);
    }

    
    
    @FXML
    private Tab tabLongeur;
    
    @FXML
    private TextField txtLongeur1;
    
    @FXML
    private TextField txtLongeur2;
    
    @FXML
    private ComboBox<String> cboLongeur1;
    
    @FXML
    private ComboBox<String> cboLongeur2;

    private ObservableList <String> listLongueur = FXCollections.observableArrayList("km", "dm", "m", "cm","mm", "mile", "yard", "foot", "inch");
    private ObservableList <String> listMasse = FXCollections.observableArrayList("kg", "g", "mg", "lbs", "ounce");
    private ObservableList <String> listTemps = FXCollections.observableArrayList("h", "min", "s", "ms", "jour", "semaine");

    
    private double []Longueur = {1.0,100,1000,100000,1000000, 0.621371, 1093.61, 3280.84, 39370.1};
    private double []Masse = {1.0,1000.0, 1000000.0, 2.205, 0.00595238};
    private double []Temps = {1.0,60.0, 3600.0, 3,600000.00, 0.0416667, 0.00595238};
    
    public void initialize (URL arg0, ResourceBundle arg1)
	{
    	cboLongeur1.setItems(listLongueur);
		cboLongeur2.setItems(listLongueur);
		cboLongeur1.getSelectionModel().selectFirst();
		cboLongeur2.getSelectionModel().selectFirst();
		
    	cboTemps1.setItems(listTemps);
		cboTemps2.setItems(listTemps);
		cboTemps1.getSelectionModel().selectFirst();
		cboTemps2.getSelectionModel().selectFirst();
		
		
	    	cboMasse1.setItems(listMasse);
			cboMasse2.setItems(listMasse);
			cboMasse1.getSelectionModel().selectFirst();
			cboMasse2.getSelectionModel().selectFirst();
		
	}
		
		private double setTaux(ComboBox a, double tbl[])
		{
			return tbl[a.getSelectionModel().getSelectedIndex()];
		}
		
	
		void convert1(ComboBox a,ComboBox b, TextField c, TextField d, double tbl[])
		{
			double from = setTaux(a,tbl);
			double to = setTaux(b,tbl);
			double depart= 0.0;
			if(c.getText().equals(""))
				depart=0.0;
			else
				depart=Double.parseDouble(c.getText());
			
			double dest=(to/from)* depart;
			d.setText(String.valueOf(dest));
		}
		
			@FXML
			void Convertir1()
			{
		
				convert1(cboLongeur1,cboLongeur2,txtLongeur1,txtLongeur2, Longueur);
			}
			
			@FXML
			void Convertir2()
			{
				convert1(cboLongeur2,cboLongeur1, txtLongeur2, txtLongeur1, Longueur);
			}

			@FXML
			private void verifNum(KeyEvent e)
			{
			TextField txt=(TextField)e.getSource();

			txt.textProperty().addListener((observable,oldValue,newValue)->

			{
			if(!newValue.matches("^-?[0-9](\\.[0-9]+)?$"))
			{
			txt.setText(newValue.replaceAll("[^\\d*\\.\\-]",""));
		
					}
				});
}
    
    @FXML
    private Tab tabTemps;
    
    @FXML
    private ComboBox<String> cboTemps1;
    
    @FXML
    private ComboBox<String> cboTemps2;

    @FXML
    private TextField txtTemps1;
    
    @FXML
    private TextField txtTemps2;
  

    


		
		private double setTaux1(ComboBox a, double tbl[])
		{
			return tbl[a.getSelectionModel().getSelectedIndex()];
		}
		
		@FXML
		void convert11(ComboBox a,ComboBox b, TextField c, TextField d, double tbl[])
		{
			double from = setTaux(a,tbl);
			double to = setTaux(b,tbl);
			double depart= 0.0;
			if(c.getText().equals(""))
				depart=0.0;
			else
				depart=Double.parseDouble(c.getText());
			
			double dest=(to/from)* depart;
			d.setText(String.valueOf(dest));
		}
		
			@FXML
			
			void Convertir11()
			{
		
				convert1(cboTemps1,cboTemps2,txtTemps1,txtTemps2, Temps);
			}
			
			@FXML
			void Convertir21()
			{
				convert1(cboTemps2,cboTemps1, txtTemps2, txtTemps1, Temps);
			}

			@FXML
			private void verifNum1(KeyEvent e)
			{
			TextField txt=(TextField)e.getSource();

			txt.textProperty().addListener((observable,oldValue,newValue)->

			{
			if(!newValue.matches("^-?[0-9](\\.[0-9]+)?$"))
			{
			txt.setText(newValue.replaceAll("[^\\d*\\.\\-]",""));
		
					}
				});
}
    
    @FXML
    private Tab tabMasse;
    
    @FXML
    private TextField txtMasse1;

    @FXML
    private TextField txtMasse2;
    
    @FXML
    private ComboBox<String> cboMasse1;
    
    @FXML
    private ComboBox<String> cboMasse2;


    
 

		
		private double setTaux2(ComboBox a, double tbl[])
		{
			return tbl[a.getSelectionModel().getSelectedIndex()];
		}
		
		@FXML
		void convert12(ComboBox a,ComboBox b, TextField c, TextField d, double tbl[])
		{
			double from = setTaux(a,tbl);
			double to = setTaux(b,tbl);
			double depart= 0.0;
			if(c.getText().equals(""))
				depart=0.0;
			else
				depart=Double.parseDouble(c.getText());
			
			double dest=(to/from)* depart;
			d.setText(String.valueOf(dest));
		}
		
			@FXML
			
			void Convertir12()
			{
		
				convert1(cboMasse1,cboMasse2,txtMasse1,txtMasse2, Masse);
			}
			
			@FXML
			void Convertir22()
			{
				convert1(cboMasse2, cboMasse1, txtMasse2, txtMasse1, Masse);
			}

			@FXML
			private void verifNum2(KeyEvent e)
			{
			TextField txt=(TextField)e.getSource();

			txt.textProperty().addListener((observable,oldValue,newValue)->

			{
			if(!newValue.matches("^-?[0-9](\\.[0-9]+)?$"))
			{
			txt.setText(newValue.replaceAll("[^\\d*\\.\\-]",""));
		
					}
				});
}
    }


