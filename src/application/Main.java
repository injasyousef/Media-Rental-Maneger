package application;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.Icon;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;


public class Main extends Application {
	
	int c=0,al=0,g=0,m=0;
	
	@Override
	public void start(Stage stage) throws FileNotFoundException {
		MediaRentalManger a=new MediaRentalManger();
		read(a);
		reada(a);
		readg(a);
		readm(a);
		
		BorderPane bp=new BorderPane();
		Button ext=new Button("Exit");
		ext.setOnAction(l -> {
			stage.close();
		});
		Label l1=new Label("       Media Rantel System");
		l1.setFont(new Font(30));
		bp.setCenter(l1);
		HBox h=new HBox();
		h.getChildren().addAll(ext,l1);
		bp.setTop(h);
		
		VBox vb=new VBox();
		Button customer = new Button("Customer");
		customer.setPrefSize(70, 50);
		customer.setAlignment(Pos.CENTER);
		
		Button media = new Button("Media");
		media.setPrefSize(70, 50);
		media.setAlignment(Pos.CENTER);
		Button rent = new Button("Rent");
		rent.setPrefSize(70, 50);
		rent.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(customer,media,rent);
		vb.setSpacing(20);
		
		ImageView i=new ImageView("https://us.123rf.com/450wm/magurok/magurok1411/magurok141100011/33213762-vector-flat-e-commerce-illustration-icon-set.jpg?ver=6");
		i.setFitWidth(300);
		i.setFitHeight(250);
		
		HBox hb=new HBox();
		hb.getChildren().addAll(vb,i);
		hb.setSpacing(20);
		bp.setCenter(hb);
		Scene scene1=new Scene(bp,400,300); 
		
		customer.setOnAction(e -> {
			GridPane gp=new GridPane();
			Button add=new Button("Add Cusstomer");
			add.setPrefSize(220, 50);
			add.setAlignment(Pos.CENTER);
			Button delete=new Button("Delete Customer");
			delete.setPrefSize(220, 50);
			delete.setAlignment(Pos.CENTER);
			Button ubdate=new Button("Ubdate Information about customer");
			ubdate.setPrefSize(220, 50);
			ubdate.setAlignment(Pos.CENTER);
			Button serch=new Button("Serch by ID");
			serch.setPrefSize(220, 50);
			serch.setAlignment(Pos.CENTER);
			Button back=new Button("Back to main menue");
			back.setPrefSize(220, 50);
			Button print=new Button("Print All Customers Information");
			print.setPrefSize(220, 50);
			print.setAlignment(Pos.CENTER);
			back.setAlignment(Pos.CENTER);
			back.setOnAction(s -> {
				stage.setScene(scene1);
				stage.show();
			});
			gp.add(add, 0, 0);
			gp.add(delete, 0, 1);
			gp.add(ubdate, 1, 0);
			gp.add(serch, 1, 1);
			gp.add(back, 0, 2);
			gp.add(print, 1, 2);
			gp.setVgap(20);
			gp.setHgap(20);
			BorderPane bp2=new BorderPane();
			bp2.setCenter(gp);
			Label l2=new Label("                    Cutomers");
			l2.setFont(new Font(30));
			l2.setTextFill(Color.RED);
			bp2.setTop(l2);
			 Scene scene2=new Scene(bp2,450,300);
			 stage.setScene(scene2);
			 stage.show();
			 
			 add.setOnAction(q -> {
					BorderPane bp3=new BorderPane();
					Label l3=new Label("          Adding Customer");
					l3.setFont(new Font(30));
					bp3.setTop(l3);
					GridPane gp2=new GridPane();
					gp2.setVgap(10);
					Label id=new Label("Customer ID:");
					id.setFont(new Font(20));
					Label name=new Label("Customer Name:");
					name.setFont(new Font(20));
					Label addres=new Label("Customer Address:");
					addres.setFont(new Font(20));
					Label mopile=new Label("Customer Mobile:");
					mopile.setFont(new Font(20));
					Label plane=new Label("Plane:");
					plane.setFont(new Font(20));
					TextArea t1=new TextArea();
					t1.setPrefSize(150, 10);
					TextArea t2=new TextArea();
					t2.setPrefSize(150, 10);
					TextArea t3=new TextArea();
					t3.setPrefSize(150, 10);
					TextArea t4=new TextArea();
					t4.setPrefSize(150, 10);
					t3.setPrefSize(150, 10);
					HBox h1=new HBox();
					h1.setSpacing(50);
					RadioButton lm = new RadioButton("limited");
					lm.setPrefSize(80, 10);
					lm.setSelected(true);
					RadioButton unlm = new RadioButton("unlimited");
					unlm.setPrefSize(80, 10);
					ToggleGroup tg=new ToggleGroup();
					lm.setToggleGroup(tg);
					unlm.setToggleGroup(tg);
					h1.getChildren().addAll(lm,unlm);
					gp2.add(id, 0, 0);
					gp2.add(name, 0, 1);
					gp2.add(addres, 0, 2);
					gp2.add(mopile, 0, 3);
					gp2.add(t1, 1, 0);
					gp2.add(t2, 1, 1);
					gp2.add(t3, 1, 2);
					gp2.add(t4, 1, 3);
					gp2.add(plane, 0, 4);
					gp2.add(h1, 1, 4);
					
					bp3.setCenter(gp2);
					
					Button addCus=new Button("Add");
					addCus.setPrefSize(80, 30);
					addCus.setOnAction(f ->{
						a.addCustomer(Double.parseDouble(t1.getText().trim()),t2.getText().trim(),t3.getText().trim(),Double.parseDouble(t4.getText().trim()),"limited");
						FileWriter out;
						try {
							out = new FileWriter(new File("customer.txt"),true);
							PrintWriter write=new PrintWriter(out);
							write.println(t1.getText()+","+t2.getText()+","+t3.getText()+","+t4.getText()+",limited,");
							write.close();
							c++;
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						t1.setText(null);
						t2.setText(null);
						t3.setText(null);
						t4.setText(null);
					});
					Button bak=new Button("Back");
					bak.setPrefSize(50, 30);
					bak.setOnAction(t -> {
						stage.setScene(scene2);
						stage.show();
						});
					HBox hb1=new HBox();
					hb1.setSpacing(110);
					hb1.getChildren().addAll(bak,addCus);
					
					bp3.setBottom(hb1);
					 Scene scene3=new Scene(bp3,400,300);
					 stage.setScene(scene3);
					 stage.show();
			 });
			 
			 delete.setOnAction(z -> {
				 BorderPane bp4=new BorderPane();
					Label l4=new Label("          Deleting Customer");
					l4.setFont(new Font(30));
					bp4.setTop(l4);
					GridPane gp3=new GridPane();
					gp3.setVgap(10);
					Label id2=new Label("Customer ID:");
					id2.setFont(new Font(20));
					Label name2=new Label("Customer Name:");
					name2.setFont(new Font(20));
					Label addres2=new Label("Customer Address:");
					addres2.setFont(new Font(20));
					Label mopile2=new Label("Customer Mobile:");
					mopile2.setFont(new Font(20));
					TextArea t5=new TextArea();
					t5.setPrefSize(150, 10);
					TextArea t6=new TextArea();
					t6.setPrefSize(150, 10);
					TextArea t7=new TextArea();
					t7.setPrefSize(150, 10);
					TextArea t8=new TextArea();
					t8.setPrefSize(150, 10);
					t7.setPrefSize(150, 10);
					gp3.add(id2, 0, 0);
					gp3.add(name2, 0, 1);
					gp3.add(addres2, 0, 2);
					gp3.add(mopile2, 0, 3);
					gp3.add(t5, 1, 0);
					gp3.add(t6, 1, 1);
					gp3.add(t7, 1, 2);
					gp3.add(t8, 1, 3);
					
					bp4.setCenter(gp3);
					
					Button deleteCus=new Button("Delete");
					deleteCus.setPrefSize(80, 30);
					deleteCus.setOnAction(p -> {
						for(int k=0;k<a.customers.size();k++) {
							if(a.customers.get(k).getId()==Double.parseDouble(t5.getText().trim())) {
								a.customers.remove(k);
								remove("customer.txt",t5.getText().trim(),c,",");
							}
						}		
						t5.setText(null);
						t6.setText(null);
						t7.setText(null);
						t8.setText(null);
					});
					Button find=new Button("Find");
					find.setPrefSize(80, 30);
					find.setOnAction(u -> {
						for(int j=0;j<a.customers.size();j++) {
							if(a.customers.get(j).getId()==Double.parseDouble(t5.getText().trim())){
								t6.setText(a.customers.get(j).getName());
								t7.setText(a.customers.get(j).getAddress());
								t8.setText(String.valueOf(a.customers.get(j).getMobile()));
								
							}
						}
					});
					Button back2=new Button("Back");
					back2.setPrefSize(80, 30);
					back2.setOnAction(x -> {
						stage.setScene(scene2);
						stage.show();
					});
					
					HBox hb2=new HBox();
					hb2.getChildren().addAll(deleteCus,find);
					hb2.setSpacing(80);
					
					HBox hb3=new HBox();
					hb3.getChildren().addAll(back2,hb2);
					hb3.setSpacing(70);
					
					bp4.setBottom(hb3);
					Scene scene4=new Scene(bp4,400,300);
					stage.setScene(scene4);
					stage.show();
				 
			 });
			 serch.setOnAction(c -> {
				 BorderPane bp5=new BorderPane();
					Label l5=new Label("          Finding Customer");
					l5.setFont(new Font(30));
					bp5.setTop(l5);
					GridPane gp4=new GridPane();
					gp4.setVgap(10);
					Label id3=new Label("Customer ID:");
					id3.setFont(new Font(20));
					Label name3=new Label("Customer Name:");
					name3.setFont(new Font(20));
					Label addres3=new Label("Customer Address:");
					addres3.setFont(new Font(20));
					Label mopile3=new Label("Customer Mobile:");
					mopile3.setFont(new Font(20));
					TextArea tt1=new TextArea();
					tt1.setPrefSize(150, 10);
					TextArea tt2=new TextArea();
					tt2.setPrefSize(150, 10);
					TextArea tt3=new TextArea();
					tt3.setPrefSize(150, 10);
					TextArea tt4=new TextArea();
					tt4.setPrefSize(150, 10);
					tt3.setPrefSize(150, 10);
					gp4.add(id3, 0, 0);
					gp4.add(name3, 0, 1);
					gp4.add(addres3, 0, 2);
					gp4.add(mopile3, 0, 3);
					gp4.add(tt1, 1, 0);
					gp4.add(tt2, 1, 1);
					gp4.add(tt3, 1, 2);
					gp4.add(tt4, 1, 3);
					
					bp5.setCenter(gp4);
					
					Button serchCus=new Button("Serch");
					serchCus.setPrefSize(80, 30);
					serchCus.setOnAction(p -> {
						for(int j=0;j<a.customers.size();j++) {
							if(a.customers.get(j).getId()==Double.parseDouble(tt1.getText().trim())){
								tt2.setText(a.customers.get(j).getName());
								tt3.setText(a.customers.get(j).getAddress());
								tt4.setText(String.valueOf(a.customers.get(j).getMobile()));
								
							}
						}
					});
					Button bakk=new Button("Back");
					bakk.setPrefSize(50, 30);
					bakk.setOnAction(w -> {
						stage.setScene(scene2);
						stage.show();
					});
					HBox hb4=new HBox();
					hb4.setSpacing(110);
					hb4.getChildren().addAll(bakk,serchCus);
					
					bp5.setBottom(hb4);
					Scene scene5=new Scene(bp5,400,300);
					stage.setScene(scene5);
					stage.show();
			 
			 });
			 ubdate.setOnAction(r -> {

					BorderPane bp6=new BorderPane();
					Label l6=new Label("          Ubdating Customer");
					l6.setFont(new Font(30));
					bp6.setTop(l6);
					GridPane gp5=new GridPane();
					gp5.setVgap(10);
					
					Label id4=new Label("Customer ID:");
					id4.setFont(new Font(20));
					Label name4=new Label("Customer Name:");
					name4.setFont(new Font(20));
					Label addres4=new Label("Customer Address:");
					addres4.setFont(new Font(20));
					Label mopile4=new Label("Customer Mobile:");
					mopile4.setFont(new Font(20));
					Label plane=new Label("Plane:");
					plane.setFont(new Font(20));
					TextArea ttt1=new TextArea();
					ttt1.setPrefSize(150, 10);
					TextArea ttt2=new TextArea();
					ttt2.setPrefSize(150, 10);
					TextArea ttt3=new TextArea();
					ttt3.setPrefSize(150, 10);
					TextArea ttt4=new TextArea();
					ttt4.setPrefSize(150, 10);
					ttt3.setPrefSize(150, 10);
					HBox h1=new HBox();
					h1.setSpacing(50);
					RadioButton lm = new RadioButton("limited");
					lm.setPrefSize(80, 10);
					lm.setSelected(true);
					RadioButton unlm = new RadioButton("unlimited");
					unlm.setPrefSize(80, 10);
					ToggleGroup tg=new ToggleGroup();
					lm.setToggleGroup(tg);
					unlm.setToggleGroup(tg);
					h1.getChildren().addAll(lm,unlm);
					
					gp5.add(id4, 0, 0);
					gp5.add(name4, 0, 1);
					gp5.add(addres4, 0, 2);
					gp5.add(mopile4, 0, 3);
					gp5.add(ttt1, 1, 0);
					gp5.add(ttt2, 1, 1);
					gp5.add(ttt3, 1, 2);
					gp5.add(ttt4, 1, 3);
					gp5.add(plane, 0, 4);
					gp5.add(h1, 1, 4);
					
					bp6.setCenter(gp5);
					
					Button ubdateCus=new Button("Ubdate");
					ubdateCus.setPrefSize(80, 30);
					Button findd=new Button("Find");
					findd.setPrefSize(80, 30);
					findd.setOnAction(c -> {
						for(int j=0;j<a.customers.size();j++) {
							if(a.customers.get(j).getId()==Double.parseDouble(ttt1.getText().trim())){
								ttt2.setText(a.customers.get(j).getName());
								ttt3.setText(a.customers.get(j).getAddress());
								ttt4.setText(String.valueOf(a.customers.get(j).getMobile()));
								
							}
						}
					});
					Button back3=new Button("Back");
					back3.setPrefSize(80, 30);
					back3.setOnAction(t -> {
						stage.setScene(scene2);
						stage.show();
					});
					
					HBox hb5=new HBox();
					hb5.getChildren().addAll(ubdateCus,findd);
					hb5.setSpacing(80);
					
					HBox hb6=new HBox();
					hb6.getChildren().addAll(back3,hb5);
					hb6.setSpacing(70);
					
					bp6.setBottom(hb6);
					Scene scene6=new Scene(bp6,400,300);
					stage.setScene(scene6);
					stage.show();
					ubdateCus.setOnAction(l -> {
						for(int n=0;n<a.customers.size();n++) {
							if(a.customers.get(n).getId()==Double.parseDouble(ttt1.getText().trim())) {
								String editTerm=ttt1.getText();
								l6.setText("            Enter new Info");
								ttt1.clear();
								ttt2.clear();
								ttt3.clear();
								ttt4.clear();
								a.customers.remove(n);
								
								Button s=new Button("Submit");
								s.setPrefSize(80, 30);
								s.setOnAction(k -> {
									a.addCustomer(Double.parseDouble(ttt1.getText().trim()),ttt2.getText(),ttt3.getText(),Double.parseDouble(ttt4.getText().trim())
											, "limited");
									String newId=ttt1.getText();
									String newName=ttt2.getText();
									String newAdress=ttt3.getText();
									String newMobile=ttt4.getText();
									try {
										ubdate("customer.txt",editTerm,newId,newName,newAdress,newMobile);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									ttt1.clear();
									ttt2.clear();
									ttt3.clear();
									ttt4.clear();
								});
								hb5.getChildren().remove(0);
								hb5.getChildren().add(s);
							}
						}
					});
			 });
			 
			 print.setOnAction(o -> {
				 BorderPane bp1=new BorderPane();
				 Label l=new Label("                    Customers Information");
				 l.setFont(new Font(20));
				 bp1.setTop(l);
				 l.setAlignment(Pos.CENTER);
				 
				 TextArea t=new TextArea();
				 t.setPrefSize(100, 100);
				 bp1.setCenter(t);
				 
				 Button back2=new Button("Back");
				 back2.setPrefSize(50, 30);
				 back2.setAlignment(Pos.CENTER);
				 back2.setOnAction(k -> {
					stage.setScene(scene2);
					stage.show();
				 });
				 Button print2=new Button("Print");
				 print2.setPrefSize(50, 30);
				 print2.setAlignment(Pos.CENTER);
				 print2.setOnAction(c -> {
					 t.setText(a.getAllCustomersInfo());
					 t.setFont(new Font(15));
				 });
				 HBox h1=new HBox();
				 h1.getChildren().addAll(back2,print2);
				 bp1.setBottom(h1);
				 h1.setAlignment( Pos.CENTER);
				 h1.setSpacing(40);
				 
				 Scene scene24=new Scene(bp1,500,300);
				 stage.setScene(scene24);
				 stage.show();
			 });
			 
			 
		});
		
		media.setOnAction(t -> {
			GridPane gp6=new GridPane();
			Button addM=new Button("Add Media");
			addM.setPrefSize(220, 50);
			addM.setAlignment(Pos.CENTER);
			Button deleteM=new Button("Delete Media");
			deleteM.setPrefSize(220, 50);
			deleteM.setAlignment(Pos.CENTER);
			Button ubdateM=new Button("Ubdate Information about a Media");
			ubdateM.setPrefSize(220, 50);
			ubdateM.setAlignment(Pos.CENTER);
			Button serchM=new Button("Serch by Code");
			serchM.setPrefSize(220, 50);
			serchM.setAlignment(Pos.CENTER);
			Button print=new Button("Print all Medies info");
			print.setPrefSize(220,50);
			print.setAlignment(Pos.CENTER);
			Button backM=new Button("Back to main menue");
			backM.setPrefSize(220, 50);
			backM.setAlignment(Pos.CENTER);
			gp6.add(addM, 0, 0);
			gp6.add(deleteM, 0, 1);
			gp6.add(ubdateM, 1, 0);
			gp6.add(serchM, 1, 1);
			gp6.add(backM, 0, 2);
			gp6.add(print, 1, 2);
			gp6.setVgap(20);
			gp6.setHgap(20);
			BorderPane bpp=new BorderPane();
			bpp.setCenter(gp6);
			Label l7=new Label("                       Medies");
			l7.setFont(new Font(30));
			l7.setTextFill(Color.RED);
			bpp.setTop(l7);
			Scene scene7=new Scene(bpp,450,300);
			stage.setScene(scene7);
			stage.show();
			
			backM.setOnAction(u -> {
				stage.setScene(scene1);
				stage.show();
			});
			
			addM.setOnAction(y -> {

				Label lm=new Label("Which type of Media do u want to add");
				lm.setFont(new Font(22));
				lm.setAlignment(Pos.TOP_CENTER);
				Button back=new Button("Back");
				back.setPrefSize(100, 50);
				Button go=new Button("Go");
				go.setPrefSize(100, 50);
				ComboBox<String> cb=new ComboBox<>();
				cb.getItems().addAll("Movie","Game","Album");
				cb.setPrefSize(200, 50);
				VBox vm=new VBox();
				vm.getChildren().addAll(lm,cb,go,back);
				vm.setSpacing(50);
				vm.setAlignment(Pos.CENTER);
				Scene scene8=new Scene(vm,400,300);
				stage.setScene(scene8);
				stage.show();
				
				back.setOnAction(f -> {
					stage.setScene(scene7);
					stage.show();
				});
				
				go.setOnAction(v -> {

					if(cb.getSelectionModel().getSelectedItem().equals("Movie")) {
						BorderPane bp7=new BorderPane();
						Label l8=new Label("          Adding Movie");
						l8.setFont(new Font(30));
						bp7.setTop(l8);
						GridPane gp7=new GridPane();
						gp7.setVgap(10);
						Label idm=new Label("Movie Code:");
						idm.setFont(new Font(20));
						Label namem=new Label("Movie Title:");
						namem.setFont(new Font(20));
						Label addresm=new Label("Number of copies:");
						addresm.setFont(new Font(20));
						Label mopilem=new Label("Movie Rating:");
						mopilem.setFont(new Font(20));
						TextArea t9=new TextArea();
						t9.setPrefSize(150, 10);
						TextArea t10=new TextArea();
						t10.setPrefSize(150, 10);
						TextArea t11=new TextArea();
						t11.setPrefSize(150, 10);
						TextArea t12=new TextArea();
						t12.setPrefSize(150, 10);
						t11.setPrefSize(150, 10);
						gp7.add(idm, 0, 0);
						gp7.add(namem, 0, 1);
						gp7.add(addresm, 0, 2);
						gp7.add(mopilem, 0, 3);
						gp7.add(t9, 1, 0);
						gp7.add(t10, 1, 1);
						gp7.add(t11, 1, 2);
						gp7.add(t12, 1, 3);
						
						bp7.setCenter(gp7);
						
						Button addMed=new Button("Add");
						addMed.setPrefSize(80, 30);
						addMed.setOnAction(c -> {
							a.addMovie(t9.getText().trim(), t10.getText().trim(),Integer.parseInt(t11.getText().trim()), t12.getText().trim());
							FileWriter out;
							try {
								out = new FileWriter(new File("movie.txt"),true);
								PrintWriter write=new PrintWriter(out);
								write.println(t9.getText()+","+t10.getText()+","+t11.getText()+","+t12.getText()+",");
								write.close();
								m++;
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							t9.clear();
							t10.clear();
							t11.clear();
							t12.clear();
						});
						Button bak3=new Button("Back");
						bak3.setOnAction(p -> {
							stage.setScene(scene8);
							stage.show();
						});
						bak3.setPrefSize(50, 30);
						HBox hb7=new HBox();
						hb7.setSpacing(110);
						hb7.getChildren().addAll(bak3,addMed);
						
						bp7.setBottom(hb7);
					Scene scene9=new Scene(bp7,400,300);
					stage.setScene(scene9);
					stage.show();
					}
					
					else if(cb.getSelectionModel().getSelectedItem().equals("Game")) {
						BorderPane bp8=new BorderPane();
						Label l9=new Label("          Adding Game");
						l9.setFont(new Font(30));
						bp8.setTop(l9);
						GridPane gp8=new GridPane();
						gp8.setVgap(10);
						Label idm1=new Label("Game Code:");
						idm1.setFont(new Font(20));
						Label namem1=new Label("Game Title:");
						namem1.setFont(new Font(20));
						Label addresm1=new Label("Number of copies:");
						addresm1.setFont(new Font(20));
						Label mopilem1=new Label("Game Weight:");
						mopilem1.setFont(new Font(20));
						TextArea tm1=new TextArea();
						tm1.setPrefSize(150, 10);
						TextArea tm2=new TextArea();
						tm2.setPrefSize(150, 10);
						TextArea tm3=new TextArea();
						tm3.setPrefSize(150, 10);
						TextArea tm4=new TextArea();
						tm4.setPrefSize(150, 10);
						tm3.setPrefSize(150, 10);
						gp8.add(idm1, 0, 0);
						gp8.add(namem1, 0, 1);
						gp8.add(addresm1, 0, 2);
						gp8.add(mopilem1, 0, 3);
						gp8.add(tm1, 1, 0);
						gp8.add(tm2, 1, 1);
						gp8.add(tm3, 1, 2);
						gp8.add(tm4, 1, 3);
						
						bp8.setCenter(gp8);
						
						Button addMed1=new Button("Add");
						addMed1.setPrefSize(80, 30);
						addMed1.setOnAction(l -> {
							a.addGame(tm1.getText().trim(),tm2.getText().trim(),Integer.parseInt(tm3.getText().trim()),Double.parseDouble(tm4.getText().trim()));
							 FileWriter out;
							try {
								out = new FileWriter(new File("game.txt"),true);
								PrintWriter write=new PrintWriter(out);
								write.println(tm1.getText()+","+tm2.getText()+","+tm3.getText()+","+tm4.getText()+",");
								write.close();
								g++;
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							tm1.clear();
							tm2.clear();
							tm3.clear();
							tm4.clear();
							 
						});
						Button bak4=new Button("Back");
						bak4.setPrefSize(50, 30);
						bak4.setOnAction(k -> {
							stage.setScene(scene8);
							stage.show();
						});
						HBox hb8=new HBox();
						hb8.setSpacing(110);
						hb8.getChildren().addAll(bak4,addMed1);
						
						bp8.setBottom(hb8);
						 Scene scene10=new Scene(bp8,400,300);
						 stage.setScene(scene10);
						 stage.show();
						
						
					}
					else if(cb.getSelectionModel().getSelectedItem().equals("Album")) {
						BorderPane bp9=new BorderPane();
						Label l10=new Label("          Adding Album");
						l10.setFont(new Font(30));
						bp9.setTop(l10);
						GridPane gp9=new GridPane();
						gp9.setVgap(10);
						Label idm2=new Label("Album Code:");
						idm2.setFont(new Font(20));
						Label namem2=new Label("ALibum Title:");
						namem2.setFont(new Font(20));
						Label addresm2=new Label("Number of copies:");
						addresm2.setFont(new Font(20));
						Label mopilem2=new Label("Album Artist:");
						mopilem2.setFont(new Font(20));
						Label song=new Label("Album Song");
						song.setFont(new Font(20));
						TextArea ta1=new TextArea();
						ta1.setPrefSize(150, 10);
						TextArea ta2=new TextArea();
						ta2.setPrefSize(150, 10);
						TextArea ta3=new TextArea();
						ta3.setPrefSize(150, 10);
						TextArea ta4=new TextArea();
						ta4.setPrefSize(150, 10);
						ta3.setPrefSize(150, 10);
						TextArea ta5=new TextArea();
						ta5.setPrefSize(150, 10);
						gp9.add(idm2, 0, 0);
						gp9.add(namem2, 0, 1);
						gp9.add(addresm2, 0, 2);
						gp9.add(mopilem2, 0, 3);
						gp9.add(song, 0, 4);
						gp9.add(ta1, 1, 0);
						gp9.add(ta2, 1, 1);
						gp9.add(ta3, 1, 2);
						gp9.add(ta4, 1, 3);
						gp9.add(ta5, 1, 4);
						
						bp9.setCenter(gp9);
						
						Button adda=new Button("Add");
						adda.setPrefSize(80, 30);
						adda.setOnAction(k -> {
							a.addAlbum(ta1.getText().trim(),ta2.getText().trim(),Integer.parseInt(ta3.getText().trim()),ta4.getText().trim(),ta5.getText().trim());
							FileWriter out;
							try {
								out = new FileWriter(new File("album.txt"),true);
								PrintWriter write=new PrintWriter(out);
								write.println(ta1.getText()+","+ta2.getText()+","+ta3.getText()+","+ta4.getText()+","+ta5.getText()+",");
								write.close();
								al++;
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							ta1.clear();
							ta2.clear();
							ta3.clear();
							ta4.clear();
							ta5.clear();
							 
						});
						Button bak5=new Button("Back");
						bak5.setPrefSize(50, 30);
						bak5.setOnAction(s -> {
							stage.setScene(scene8);
							stage.show();
						});
						HBox hb9=new HBox();
						hb9.setSpacing(110);
						hb9.getChildren().addAll(bak5,adda);
						
						bp9.setBottom(hb9);
						 Scene scene11=new Scene(bp9,400,310);
						 stage.setScene(scene11);
						 stage.show();
					}
				});
				
				
			});
			
			deleteM.setOnAction(u -> {
				Label ld=new Label("Which type of Media do u want to Delete");
				ld.setFont(new Font(22));
				ld.setAlignment(Pos.TOP_CENTER);
				Button back=new Button("Back");
				back.setPrefSize(100, 50);
				back.setOnAction(p -> {
					stage.setScene(scene7);
					stage.show();
				});
				Button go=new Button("Go");
				go.setPrefSize(100, 50);
				ComboBox<String> cb2=new ComboBox<>();
				cb2.getItems().addAll("Movie","Game","Album");
				cb2.setPrefSize(200, 50);
				VBox vm2=new VBox();
				vm2.getChildren().addAll(ld,cb2,go,back);
				vm2.setSpacing(50);
				vm2.setAlignment(Pos.CENTER);
				 Scene scene12=new Scene(vm2,420,300);
				 stage.setScene(scene12);
				 stage.show();
				 
				 go.setOnAction(l -> {
					 if(cb2.getSelectionModel().getSelectedItem().equals("Movie")) {
						 BorderPane bp10=new BorderPane();
							Label l8=new Label("          Deleting Movie");
							l8.setFont(new Font(30));
							bp10.setTop(l8);
							GridPane gp10=new GridPane();
							gp10.setVgap(10);
							Label idd=new Label("Movie Code:");
							idd.setFont(new Font(20));
							Label named=new Label("Movie Title:");
							named.setFont(new Font(20));
							Label addresd=new Label("Number of copies:");
							addresd.setFont(new Font(20));
							Label mopiled=new Label("Movie Rating:");
							mopiled.setFont(new Font(20));
							TextArea td9=new TextArea();
							td9.setPrefSize(150, 10);
							TextArea td10=new TextArea();
							td10.setPrefSize(150, 10);
							TextArea td11=new TextArea();
							td11.setPrefSize(150, 10);
							TextArea td12=new TextArea();
							td12.setPrefSize(150, 10);
							td11.setPrefSize(150, 10);
							gp10.add(idd, 0, 0);
							gp10.add(named, 0, 1);
							gp10.add(addresd, 0, 2);
							gp10.add(mopiled, 0, 3);
							gp10.add(td9, 1, 0);
							gp10.add(td10, 1, 1);
							gp10.add(td11, 1, 2);
							gp10.add(td12, 1, 3);
							
							bp10.setCenter(gp10);
							
							Button addd=new Button("Delete");
							addd.setPrefSize(80, 30);
							addd.setOnAction(k -> {
								for(int z=0;z<a.medies.size();z++) {
									if(a.medies.get(z).getCode().equals(td9.getText().trim())) {
										a.medies.remove(z);
										remove("movie.txt",td9.getText(),m,",");
									}
								}
								td9.clear();
								td10.clear();
								td11.clear();
								td12.clear();
							});
						    Button  bak6=new Button("Back");
							bak6.setPrefSize(50, 30);
							bak6.setOnAction(r -> {
								stage.setScene(scene12);
								stage.show();
							});
							Button find2=new Button("Find");
							find2.setPrefSize(50, 30);
							find2.setOnAction(e -> {
								for(int g=0;g<a.medies.size();g++) {
									if(a.medies.get(g).getCode().equals(td9.getText().trim())) {
										td10.setText(a.medies.get(g).getTitle());
										td11.setText(String.valueOf(a.medies.get(g).getNoc()));
										td12.setText(((Movie) a.medies.get(g)).getRating());
									}
									
								}
							});
							HBox hb10=new HBox();
							hb10.setSpacing(110);
							hb10.getChildren().addAll(bak6,addd,find2);
							
							bp10.setBottom(hb10);
							 Scene scene13=new Scene(bp10,400,300);
							 stage.setScene(scene13);
							 stage.show();
					 }
					 else if(cb2.getSelectionModel().getSelectedItem().equals("Game")) {
						 BorderPane bp11=new BorderPane();
							Label lg9=new Label("          Deleting Game");
							lg9.setFont(new Font(30));
							bp11.setTop(lg9);
							GridPane gp11=new GridPane();
							gp11.setVgap(10);
							Label idm3=new Label("Game Code:");
							idm3.setFont(new Font(20));
							Label namem3=new Label("Game Title:");
							namem3.setFont(new Font(20));
							Label addresm3=new Label("Number of copies:");
							addresm3.setFont(new Font(20));
							Label mopilem3=new Label("Game Weight:");
							mopilem3.setFont(new Font(20));
							TextArea tm5=new TextArea();
							tm5.setPrefSize(150, 10);
							TextArea tm6=new TextArea();
							tm6.setPrefSize(150, 10);
							TextArea tm7=new TextArea();
							tm7.setPrefSize(150, 10);
							TextArea tm8=new TextArea();
							tm8.setPrefSize(150, 10);
							tm7.setPrefSize(150, 10);
							gp11.add(idm3, 0, 0);
							gp11.add(namem3, 0, 1);
							gp11.add(addresm3, 0, 2);
							gp11.add(mopilem3, 0, 3);
							gp11.add(tm5, 1, 0);
							gp11.add(tm6, 1, 1);
							gp11.add(tm7, 1, 2);
							gp11.add(tm8, 1, 3);
							
							bp11.setCenter(gp11);
							
							Button addMed2=new Button("Delete");
							addMed2.setPrefSize(80, 30);
							addMed2.setOnAction(o -> {
								for(int j=0;j<a.medies.size();j++) {
									if(a.medies.get(j).getCode().equals(tm5.getText().trim())) {
										a.medies.remove(j);
										remove("game.txt",tm5.getText(),g,",");
									}
								}
								tm5.clear();
								tm6.clear();
								tm7.clear();
								tm8.clear();
							});
							Button bak7=new Button("Back");
							bak7.setPrefSize(50, 30);
							bak7.setOnAction(n -> {
								stage.setScene(scene12);
								stage.show();
							});
							Button find3=new Button("Find");
							find3.setPrefSize(50, 30);
							find3.setOnAction(p -> {
								for(int g=0;g<a.medies.size();g++) {
									if(a.medies.get(g).getCode().equals(tm5.getText().trim())) {
										tm6.setText(a.medies.get(g).getTitle());
										tm7.setText(String.valueOf(a.medies.get(g).getNoc()));
										tm8.setText(String.valueOf(((Game) a.medies.get(g)).getWeight()));
										
									}
									
								}
							});
							HBox hb11=new HBox();
							hb11.setSpacing(110);
							hb11.getChildren().addAll(bak7,addMed2,find3);
							
							bp11.setBottom(hb11);
							 Scene scene14=new Scene(bp11,400,300);
							 stage.setScene(scene14);
							 stage.show();
					 }
					 
					 else if(cb2.getSelectionModel().getSelectedItem().equals("Album")) {
						 BorderPane bp12=new BorderPane();
							Label ll=new Label("          Deleting Album");
							ll.setFont(new Font(30));
							bp12.setTop(ll);
							GridPane gp12=new GridPane();
							gp12.setVgap(10);
							Label idm4=new Label("Album Code:");
							idm4.setFont(new Font(20));
							Label namem4=new Label("ALibum Title:");
							namem4.setFont(new Font(20));
							Label addresm4=new Label("Number of copies:");
							addresm4.setFont(new Font(20));
							Label mopilem4=new Label("Album Artist:");
							mopilem4.setFont(new Font(20));
							Label song2=new Label("Album Song");
							song2.setFont(new Font(20));
							TextArea ta6=new TextArea();
							ta6.setPrefSize(150, 10);
							TextArea ta7=new TextArea();
							ta7.setPrefSize(150, 10);
							TextArea ta8=new TextArea();
							ta8.setPrefSize(150, 10);
							TextArea ta9=new TextArea();
							ta9.setPrefSize(150, 10);
							ta8.setPrefSize(150, 10);
							TextArea ta10=new TextArea();
							ta10.setPrefSize(150, 10);
							gp12.add(idm4, 0, 0);
							gp12.add(namem4, 0, 1);
							gp12.add(addresm4, 0, 2);
							gp12.add(mopilem4, 0, 3);
							gp12.add(song2, 0, 4);
							gp12.add(ta6, 1, 0);
							gp12.add(ta7, 1, 1);
							gp12.add(ta8, 1, 2);
							gp12.add(ta9, 1, 3);
							gp12.add(ta10, 1, 4);
							
							bp12.setCenter(gp12);
							
							Button del=new Button("Delete");
							del.setPrefSize(80, 30);
							del.setOnAction(b -> {
								for(int z=0;z<a.medies.size();z++) {
									if(a.medies.get(z).getCode().equals(ta6.getText().trim())) {
										a.medies.remove(z);
										remove("album.txt",ta6.getText(),al,",");
									}
								}
								ta6.clear();
								ta7.clear();
								ta8.clear();
								ta9.clear();
								ta10.clear();
							});
							Button bak8=new Button("Back");
							bak8.setPrefSize(50, 30);
							bak8.setOnAction(g -> {
								stage.setScene(scene12);
								stage.show();
							});
							Button find4=new Button("Find");
							find4.setPrefSize(50, 30);
							find4.setOnAction(f -> {
								for(int x=0;x<a.medies.size();x++) {
									if(a.medies.get(x).getCode().equals(ta6.getText().trim())) {
										ta7.setText(a.medies.get(x).getTitle());
										ta8.setText(String.valueOf(a.medies.get(x).getNoc()));
										ta9.setText(((Album) a.medies.get(x)).getArtist());
										ta10.setText(((Album) a.medies.get(x)).getSong());
									}	
								}
							});
							HBox hb12=new HBox();
							hb12.setSpacing(110);
							hb12.getChildren().addAll(bak8,del,find4);
							
							bp12.setBottom(hb12);
							Scene scene15=new Scene(bp12,400,300);
							stage.setScene(scene15);
							stage.show();
							
					 }
					 
				 });
				 
				 
			});
			
			ubdateM.setOnAction(u -> {
				Label lu=new Label("Which type of Media do u want to Ubdate");
				lu.setFont(new Font(22));
				lu.setAlignment(Pos.TOP_CENTER);
				Button back=new Button("Back");
				back.setPrefSize(100, 50);
				back.setOnAction(p ->{
					stage.setScene(scene7);
					stage.show();
				});
				Button go=new Button("Go");
				go.setPrefSize(100, 50);
				ComboBox<String> cb3=new ComboBox<>();
				cb3.getItems().addAll("Movie","Game","Album");
				cb3.setPrefSize(200, 50);
				VBox vm3=new VBox();
				vm3.getChildren().addAll(lu,cb3,go,back);
				vm3.setSpacing(50);
				vm3.setAlignment(Pos.CENTER);
				 Scene scene16=new Scene(vm3,430,300);
				 stage.setScene(scene16);
				 stage.show();
				 
				 go.setOnAction(k -> {
					 if(cb3.getSelectionModel().getSelectedItem().equals("Movie")) {
						 BorderPane bp13=new BorderPane();
							Label l8=new Label("          Ubdating Movie");
							l8.setFont(new Font(30));
							bp13.setTop(l8);
							GridPane gp13=new GridPane();
							gp13.setVgap(10);
							Label idd2=new Label("Movie Code:");
							idd2.setFont(new Font(20));
							Label named2=new Label("Movie Title:");
							named2.setFont(new Font(20));
							Label addresd2=new Label("Number of copies:");
							addresd2.setFont(new Font(20));
							Label mopiled2=new Label("Movie Rating:");
							mopiled2.setFont(new Font(20));
							TextArea tu1=new TextArea();
							tu1.setPrefSize(150, 10);
							TextArea tu2=new TextArea();
							tu2.setPrefSize(150, 10);
							TextArea tu3=new TextArea();
							tu3.setPrefSize(150, 10);
							TextArea tu4=new TextArea();
							tu4.setPrefSize(150, 10);
							tu3.setPrefSize(150, 10);
							gp13.add(idd2, 0, 0);
							gp13.add(named2, 0, 1);
							gp13.add(addresd2, 0, 2);
							gp13.add(mopiled2, 0, 3);
							gp13.add(tu1, 1, 0);
							gp13.add(tu2, 1, 1);
							gp13.add(tu3, 1, 2);
							gp13.add(tu4, 1, 3);
							
							bp13.setCenter(gp13);
							
							Button ubdate2=new Button("Ubdate");
							ubdate2.setPrefSize(80, 30);
						    Button  bak9=new Button("Back");
							bak9.setPrefSize(50, 30);
							bak9.setOnAction(b ->{
								stage.setScene(scene16);
								stage.show();
							});
							Button find5=new Button("Find");
							find5.setPrefSize(50, 30);
							find5.setOnAction(v -> {
								for(int g=0;g<a.medies.size();g++) {
									if(a.medies.get(g).getCode().equals(tu1.getText().trim())) {
										tu2.setText(a.medies.get(g).getTitle());
										tu3.setText(String.valueOf(a.medies.get(g).getNoc()));
										tu4.setText(((Movie) a.medies.get(g)).getRating());
									}
									
								}
							});
							HBox hb13=new HBox();
							hb13.setSpacing(110);
							hb13.getChildren().addAll(bak9,ubdate2,find5);
							
							bp13.setBottom(hb13);
							Scene scene17=new Scene(bp13,400,300);
							stage.setScene(scene17);
							stage.show();
							ubdate2.setOnAction(b -> {
								for(int s=0;s<a.medies.size();s++) {
									if(a.medies.get(s).getCode().equals(tu1.getText().trim())) {
										String editTerm=tu1.getText();
										l8.setText("         Enter New Info");
										tu1.clear();
										tu2.clear();
										tu3.clear();
										tu4.clear();
										a.medies.remove(s);
										
										Button sub=new Button("Submit");
										sub.setPrefSize(80, 30);
										sub.setOnAction(v -> {
											a.addMovie(tu1.getText(),tu2.getText(),Integer.parseInt(tu3.getText().trim()),tu4.getText());
											String newCode=tu1.getText();
											String newTitle=tu2.getText();
											int newNoc=Integer.parseInt(tu3.getText());
											String newRating=tu4.getText();
											
											try {
												ubdatem("movie.txt",editTerm,newCode,newTitle,newNoc,newRating);
											}
											catch(IOException e2) {
												e2.printStackTrace();
											}
											tu1.clear();
											tu2.clear();
											tu3.clear();
											tu4.clear();
										});
										hb13.getChildren().remove(1);
										hb13.getChildren().add(sub);
									}
								}
							});
							
					 }
					 else if(cb3.getSelectionModel().getSelectedItem().equals("Game")) {
						 BorderPane bp14=new BorderPane();
							Label lg10=new Label("          Ubdating Game");
							lg10.setFont(new Font(30));
							bp14.setTop(lg10);
							GridPane gp14=new GridPane();
							gp14.setVgap(10);
							Label idg=new Label("Game Code:");
							idg.setFont(new Font(20));
							Label nameg=new Label("Game Title:");
							nameg.setFont(new Font(20));
							Label addresg=new Label("Number of copies:");
							addresg.setFont(new Font(20));
							Label mopileg=new Label("Game Weight:");
							mopileg.setFont(new Font(20));
							TextArea tg1=new TextArea();
							tg1.setPrefSize(150, 10);
							TextArea tg2=new TextArea();
							tg2.setPrefSize(150, 10);
							TextArea tg3=new TextArea();
							tg3.setPrefSize(150, 10);
							TextArea tg4=new TextArea();
							tg4.setPrefSize(150, 10);
							tg3.setPrefSize(150, 10);
							gp14.add(idg, 0, 0);
							gp14.add(nameg, 0, 1);
							gp14.add(addresg, 0, 2);
							gp14.add(mopileg, 0, 3);
							gp14.add(tg1, 1, 0);
							gp14.add(tg2, 1, 1);
							gp14.add(tg3, 1, 2);
							gp14.add(tg4, 1, 3);
							
							bp14.setCenter(gp14);
							
							Button ubdate3=new Button("Ubdate");
							ubdate3.setPrefSize(80, 30);
							Button bak10=new Button("Back");
							bak10.setPrefSize(50, 30);
							bak10.setOnAction(g -> {
								stage.setScene(scene16);
								stage.show();
							});
							Button find6=new Button("Find");
							find6.setPrefSize(50, 30);
							find6.setOnAction(j -> {
								for(int g=0;g<a.medies.size();g++) {
									if(a.medies.get(g).getCode().equals(tg1.getText().trim())) {
										tg2.setText(a.medies.get(g).getTitle());
										tg3.setText(String.valueOf(a.medies.get(g).getNoc()));
										tg4.setText(String.valueOf(((Game) a.medies.get(g)).getWeight()));
									}
								}
							});
							HBox hb14=new HBox();
							hb14.setSpacing(110);
							hb14.getChildren().addAll(bak10,ubdate3,find6);
							
							bp14.setBottom(hb14);
							 Scene scene18=new Scene(bp14,400,300);
							 stage.setScene(scene18);
							 stage.show();
							 
							 ubdate3.setOnAction(x -> {
								for(int o=0;o<a.medies.size();o++) {
									if(a.medies.get(o).getCode().equals(tg1.getText().trim())){
										String editTerm=tg1.getText();
										lg10.setText("          Enter new Info");
										tg1.clear();
										tg2.clear();
										tg3.clear();
										tg4.clear();
										a.medies.remove(o);
										
										Button sub2=new Button("Submit");
										sub2.setPrefSize(80,30);
										sub2.setOnAction(v -> {
											a.addGame(tg1.getText().trim(),tg2.getText().trim(),Integer.parseInt(tg3.getText().trim()),Double.parseDouble(tg4.getText().trim()));
											String newCode=tg1.getText();
											String newTitle=tg2.getText();
											int newNoc=Integer.parseInt(tg3.getText());
											double newWieght=Double.parseDouble(tg4.getText());
											
											try {
												ubdateg("game.txt",editTerm,newCode,newTitle,newNoc,newWieght);
											} catch (IOException e1) {
												e1.printStackTrace();
											}
											tg1.clear();
											tg2.clear();
											tg3.clear();
											tg4.clear();
										});
										hb14.getChildren().remove(1);
										hb14.getChildren().add(sub2);
									}
								}
							 });
							
					 }
					 else if(cb3.getSelectionModel().getSelectedItem().equals("Album")) {
						 BorderPane bp15=new BorderPane();
							Label ll2=new Label("          Ubdating Album");
							ll2.setFont(new Font(30));
							bp15.setTop(ll2);
							GridPane gp15=new GridPane();
							gp15.setVgap(10);
							Label idm5=new Label("Album Code:");
							idm5.setFont(new Font(20));
							Label namem5=new Label("ALibum Title:");
							namem5.setFont(new Font(20));
							Label addresm5=new Label("Number of copies:");
							addresm5.setFont(new Font(20));
							Label mopilem5=new Label("Album Artist:");
							mopilem5.setFont(new Font(20));
							Label song3=new Label("Album Song");
							song3.setFont(new Font(20));
							TextArea ta11=new TextArea();
							ta11.setPrefSize(150, 10);
							TextArea ta12=new TextArea();
							ta12.setPrefSize(150, 10);
							TextArea ta13=new TextArea();
							ta13.setPrefSize(150, 10);
							TextArea ta14=new TextArea();
							ta14.setPrefSize(150, 10);
							ta13.setPrefSize(150, 10);
							TextArea ta15=new TextArea();
							ta15.setPrefSize(150, 10);
							gp15.add(idm5, 0, 0);
							gp15.add(namem5, 0, 1);
							gp15.add(addresm5, 0, 2);
							gp15.add(mopilem5, 0, 3);
							gp15.add(song3, 0, 4);
							gp15.add(ta11, 1, 0);
							gp15.add(ta12, 1, 1);
							gp15.add(ta13, 1, 2);
							gp15.add(ta14, 1, 3);
							gp15.add(ta15, 1, 4);
							
							bp15.setCenter(gp15);
							
							Button ubd=new Button("Ubdate");
							ubd.setPrefSize(80, 30);
							Button bak11=new Button("Back");
							bak11.setPrefSize(50, 30);
							bak11.setOnAction(x ->{
								stage.setScene(scene16);
								stage.show();
							});
							Button find7=new Button("Find");
							find7.setPrefSize(50, 30);
							find7.setOnAction(j -> {
								for(int x=0;x<a.medies.size();x++) {
									if(a.medies.get(x).getCode().equals(ta11.getText().trim())) {
										ta12.setText(a.medies.get(x).getTitle());
										ta13.setText(String.valueOf(a.medies.get(x).getNoc()));
										ta14.setText(((Album) a.medies.get(x)).getArtist());
										ta15.setText(((Album) a.medies.get(x)).getSong());
									}	
								}
							});
							HBox hb15=new HBox();
							hb15.setSpacing(110);
							hb15.getChildren().addAll(bak11,ubd,find7);
							
							bp15.setBottom(hb15);
							 Scene scene19=new Scene(bp15,400,300);
							 stage.setScene(scene19);
							 stage.show();
							 
							 ubd.setOnAction(e -> {
								for(int j=0;j<a.medies.size();j++) {
									if(a.medies.get(j).getCode().equals(ta11.getText())) {
										String editTerm=ta11.getText();
										ll2.setText("            Enter New Info");
										ta11.clear();
										ta12.clear();
										ta13.clear();
										ta14.clear();
										ta15.clear();
										a.medies.remove(j);
										
										Button sub3=new Button("Submit");
										sub3.setPrefSize(80, 30);
										sub3.setOnAction(s -> {
											a.addAlbum(ta11.getText(),ta12.getText(), Integer.parseInt(ta13.getText()),ta14.getText(),ta15.getText());
											
											String newCode=ta11.getText();
											String newTitle=ta12.getText();
											int newNoc=Integer.parseInt(ta13.getText());
											String newArtist=ta14.getText();
											String newSong=ta15.getText();
											
											try {
												ubdatea("album.txt",editTerm,newCode,newTitle,newNoc,newArtist,newSong);
											} catch (IOException e1) {
												e1.printStackTrace();
											}
											ta11.clear();
											ta12.clear();
											ta13.clear();
											ta14.clear();
											ta15.clear();
										});
										hb15.getChildren().remove(1);
										hb15.getChildren().add(sub3);
									}
								}
							 });
					 }
					 
				 });
			});
			
			serchM.setOnAction(j ->{
				Label lu2=new Label("Which type of Media do u want to Serch");
				lu2.setFont(new Font(22));
				lu2.setAlignment(Pos.TOP_CENTER);
				Button back=new Button("Back");
				back.setPrefSize(100, 50);
				back.setOnAction(b ->{
					stage.setScene(scene7);
					stage.show();
				});
				Button go=new Button("Go");
				go.setPrefSize(100, 50);
				ComboBox<String> cb4=new ComboBox<>();
				cb4.getItems().addAll("Movie","Game","Album");
				cb4.setPrefSize(200, 50);
				VBox vm4=new VBox();
				vm4.getChildren().addAll(lu2,cb4,go,back);
				vm4.setSpacing(50);
				vm4.setAlignment(Pos.CENTER);
				Scene scene20=new Scene(vm4,420,300);
				stage.setScene(scene20);
				stage.show();
				
				go.setOnAction(l ->{
					if(cb4.getSelectionModel().getSelectedItem().equals("Movie")) {
						BorderPane bp16=new BorderPane();
						Label lm8=new Label("       Serching about Movie");
						lm8.setFont(new Font(30));
						bp16.setTop(lm8);
						GridPane gp16=new GridPane();
						gp16.setVgap(10);
						Label idmo=new Label("Movie Code:");
						idmo.setFont(new Font(20));
						Label namemo=new Label("Movie Title:");
						namemo.setFont(new Font(20));
						Label addresmo=new Label("Number of copies:");
						addresmo.setFont(new Font(20));
						Label mopilemo=new Label("Movie Rating:");
						mopilemo.setFont(new Font(20));
						TextArea to1=new TextArea();
						to1.setPrefSize(150, 10);
						TextArea to2=new TextArea();
						to2.setPrefSize(150, 10);
						TextArea to3=new TextArea();
						to3.setPrefSize(150, 10);
						TextArea to4=new TextArea();
						to4.setPrefSize(150, 10);
						to3.setPrefSize(150, 10);
						gp16.add(idmo, 0, 0);
						gp16.add(namemo, 0, 1);
						gp16.add(addresmo, 0, 2);
						gp16.add(mopilemo, 0, 3);
						gp16.add(to1, 1, 0);
						gp16.add(to2, 1, 1);
						gp16.add(to3, 1, 2);
						gp16.add(to4, 1, 3);
						
						bp16.setCenter(gp16);
						
						Button ser=new Button("Serch");
						ser.setPrefSize(80, 30);
						ser.setOnAction(m -> {
							for(int g=0;g<a.medies.size();g++) {
								if(a.medies.get(g).getCode().equals(to1.getText().trim())) {
									to2.setText(a.medies.get(g).getTitle());
									to3.setText(String.valueOf(a.medies.get(g).getNoc()));
									to4.setText(((Movie) a.medies.get(g)).getRating());
								}
								
							}
						});
						Button baak=new Button("Back");
						baak.setPrefSize(50, 30);
						baak.setOnAction(d -> {
							stage.setScene(scene20);
							stage.show();
						});
						HBox hb16=new HBox();
						hb16.setSpacing(110);
						hb16.getChildren().addAll(baak,ser);
						
						bp16.setBottom(hb16);
						Scene scene21=new Scene(bp16,400,300);
						stage.setScene(scene21);
						stage.show();
						
					}
					
					else if(cb4.getSelectionModel().getSelectedItem().equals("Game")) {
						BorderPane bp17=new BorderPane();
						Label l13=new Label("        Serch About Game");
						l13.setFont(new Font(30));
						bp17.setTop(l13);
						GridPane gp17=new GridPane();
						gp17.setVgap(10);
						Label idm6=new Label("Game Code:");
						idm6.setFont(new Font(20));
						Label namem6=new Label("Game Title:");
						namem6.setFont(new Font(20));
						Label addresm6=new Label("Number of copies:");
						addresm6.setFont(new Font(20));
						Label mopilem6=new Label("Game Weight:");
						mopilem6.setFont(new Font(20));
						TextArea tma1=new TextArea();
						tma1.setPrefSize(150, 10);
						TextArea tma2=new TextArea();
						tma2.setPrefSize(150, 10);
						TextArea tma3=new TextArea();
						tma3.setPrefSize(150, 10);
						TextArea tma4=new TextArea();
						tma4.setPrefSize(150, 10);
						tma3.setPrefSize(150, 10);
						gp17.add(idm6, 0, 0);
						gp17.add(namem6, 0, 1);
						gp17.add(addresm6, 0, 2);
						gp17.add(mopilem6, 0, 3);
						gp17.add(tma1, 1, 0);
						gp17.add(tma2, 1, 1);
						gp17.add(tma3, 1, 2);
						gp17.add(tma4, 1, 3);
						
						bp17.setCenter(gp17);
						
						Button ser2=new Button("Serch");
						ser2.setPrefSize(80, 30);
						ser2.setOnAction(b -> {
							for(int g=0;g<a.medies.size();g++) {
								if(a.medies.get(g).getCode().equals(tma1.getText().trim())) {
									tma2.setText(a.medies.get(g).getTitle());
									tma3.setText(String.valueOf(a.medies.get(g).getNoc()));
									tma4.setText(String.valueOf(((Game) a.medies.get(g)).getWeight()));
									
								}
								
							}
						});
						Button bak2=new Button("Back");
						bak2.setPrefSize(50, 30);
						bak2.setOnAction(o ->{
							stage.setScene(scene20);
							stage.show();
						});
						HBox hb17=new HBox();
						hb17.setSpacing(110);
						hb17.getChildren().addAll(bak2,ser2);
						
						bp17.setBottom(hb17);
						 Scene scene22=new Scene(bp17,400,300);
						 stage.setScene(scene22);
						 stage.show();
					}
					
					else if(cb4.getSelectionModel().getSelectedItem().equals("Album")) {
						BorderPane bp18=new BorderPane();
						Label l11=new Label("        Serch About Album");
						l11.setFont(new Font(30));
						bp18.setTop(l11);
						GridPane gp18=new GridPane();
						gp18.setVgap(10);
						Label idm7=new Label("Album Code:");
						idm7.setFont(new Font(20));
						Label namem7=new Label("ALbum Title:");
						namem7.setFont(new Font(20));
						Label addresm7=new Label("Number of copies:");
						addresm7.setFont(new Font(20));
						Label mopilem7=new Label("Album Artist:");
						mopilem7.setFont(new Font(20));
						Label song7=new Label("Album Song");
						song7.setFont(new Font(20));
						TextArea tal1=new TextArea();
						tal1.setPrefSize(150, 10);
						TextArea tal2=new TextArea();
						tal2.setPrefSize(150, 10);
						TextArea tal3=new TextArea();
						tal3.setPrefSize(150, 10);
						TextArea tal4=new TextArea();
						tal4.setPrefSize(150, 10);
						tal3.setPrefSize(150, 10);
						TextArea tal5=new TextArea();
						tal5.setPrefSize(150, 10);
						gp18.add(idm7, 0, 0);
						gp18.add(namem7, 0, 1);
						gp18.add(addresm7, 0, 2);
						gp18.add(mopilem7, 0, 3);
						gp18.add(song7, 0, 4);
						gp18.add(tal1, 1, 0);
						gp18.add(tal2, 1, 1);
						gp18.add(tal3, 1, 2);
						gp18.add(tal4, 1, 3);
						gp18.add(tal5, 1, 4);
						
						bp18.setCenter(gp18);
						
						Button ser3=new Button("Serch");
						ser3.setPrefSize(80, 30);
						ser3.setOnAction(k -> {
							for(int x=0;x<a.medies.size();x++) {
								if(a.medies.get(x).getCode().equals(tal1.getText().trim())) {
									tal2.setText(a.medies.get(x).getTitle());
									tal3.setText(String.valueOf(a.medies.get(x).getNoc()));
									tal4.setText(((Album) a.medies.get(x)).getArtist());
									tal5.setText(((Album) a.medies.get(x)).getSong());
								}	
							}
						});
						Button bak12=new Button("Back");
						bak12.setPrefSize(50, 30);
						bak12.setOnAction(e -> {
							stage.setScene(scene20);
							stage.show();
						});
						HBox hb18=new HBox();
						hb18.setSpacing(110);
						hb18.getChildren().addAll(bak12,ser3);
						
						bp18.setBottom(hb18);
						 Scene scene23=new Scene(bp18,400,300);
						 stage.setScene(scene23);
						 stage.show();
						
					}
				});
				
			});		
			print.setOnAction(n ->{
				BorderPane bp1=new BorderPane();
				 Label l=new Label("                    Medies Information");
				 l.setFont(new Font(20));
				 bp1.setTop(l);
				 l.setAlignment(Pos.CENTER);
				 
				 TextArea t2=new TextArea();
				 t2.setPrefSize(100, 100);
				 bp1.setCenter(t2);
				 
				 Button back2=new Button("Back");
				 back2.setPrefSize(50, 30);
				 back2.setAlignment(Pos.CENTER);
				 back2.setOnAction(k -> {
					stage.setScene(scene7);
					stage.show();
				 });
				 Button print2=new Button("Print");
				 print2.setPrefSize(50, 30);
				 print2.setAlignment(Pos.CENTER);
				 print2.setOnAction(c -> {
					 t2.setText(a.getAllMediaInfo());
					 t2.setFont(new Font(15));
				 });
				 HBox h1=new HBox();
				 h1.getChildren().addAll(back2,print2);
				 bp1.setBottom(h1);
				 h1.setAlignment( Pos.CENTER);
				 h1.setSpacing(40);
				 
				 Scene scene25=new Scene(bp1,400,300);
				 stage.setScene(scene25);
				 stage.show();
			});
			
		});
		
		rent.setOnAction(y -> {
			BorderPane bp5=new BorderPane();
			Label l=new Label("                           Renting");
			l.setFont(new Font(20));
			bp5.setTop(l);
			
			Label l2=new Label("Customer ID: ");
			l2.setFont(new Font(15));
			HBox h2=new HBox();
			Button fnd=new Button("Find");
			fnd.setPrefSize(50, 30);
			fnd.setAlignment(Pos.CENTER);
			TextArea t=new TextArea();
			t.setPrefSize(150, 30);
			h2.getChildren().addAll(t,fnd);
			h2.setSpacing(10);
			
			TextArea t2=new TextArea();
			t2.setPrefSize(150, 100);
			fnd.setOnAction(d -> {
				for(int f=0;f<a.customers.size();f++) {
					if(a.customers.get(f).getId()==Double.parseDouble(t.getText().trim())) {
						t2.setText("ID: "+a.customers.get(f).getId()+"\nName: "+a.customers.get(f).getName()+"\nAddress: "+a.customers.get(f).getAddress()
								+"\nMobile: "+a.customers.get(f).getMobile()+"\nPlane: "+a.customers.get(f).getPlan());
					}
				}
			});
			
			Label l3=new Label("Media Code: ");
			l3.setFont(new Font(15));
			HBox h3=new HBox();
			Button fnd2=new Button("Find");
			fnd2.setPrefSize(50, 30);
			fnd2.setAlignment(Pos.CENTER);
			TextArea t3=new TextArea();
			t3.setPrefSize(150, 30);
			h3.getChildren().addAll(t3,fnd2);
			h3.setSpacing(10);
			
			TextArea t4=new TextArea();
			t4.setPrefSize(150, 100);
			fnd2.setOnAction(v -> {
				for(int j=0;j<a.medies.size();j++) {
					if(a.medies.get(j).getCode().equals(t3.getText().trim())) {
						if(a.medies.get(j) instanceof Movie) {
							t4.setText("Code: "+a.medies.get(j).getCode()+"\nTitle: "+a.medies.get(j).getTitle()+"\nNumber Of Copies: "+a.medies.get(j).getNoc()+"\nRating: "+((Movie) a.medies.get(j)).getRating());
						}
						else if(a.medies.get(j) instanceof Game) {
							t4.setText("Code: "+a.medies.get(j).getCode()+"\nTitle: "+a.medies.get(j).getTitle()+"\nNumber Of Copies: "+a.medies.get(j).getNoc()+"\nWeight: "+((Game) a.medies.get(j)).getWeight());
						}
						else if(a.medies.get(j) instanceof Album) {
							t4.setText("Code: "+a.medies.get(j).getCode()+"\nTitle: "+a.medies.get(j).getTitle()+"\nNumber Of Copies: "
						    +a.medies.get(j).getNoc()+"\nArtist: "+((Album) a.medies.get(j)).getArtist()+"\nSong: "+((Album) a.medies.get(j)).getSong());
						}
					}
				}
			});
			
			Label l4=new Label("Rented Date");
			l4.setFont(new Font(15));
			
			TextArea t5=new TextArea();
			t5.setPrefSize(175, 30);
			Button c=new Button("Creat");
			c.setPrefSize(50, 30);
			c.setOnAction(g -> {
				t5.setText(new java.util.Date().toString());
			});
			HBox h9=new HBox();
			h9.getChildren().addAll(t5,c);
			h9.setSpacing(10);
			
			
			
			GridPane gp=new GridPane();
			gp.add(l2, 0, 0);
			gp.add(h2, 1, 0);
			gp.add(t2, 1, 1);
			gp.add(l3, 0, 2);
			gp.add(h3, 1, 2);
			gp.add(t4, 1, 3);
			gp.add(l4, 0, 4);
			gp.add(h9, 1, 4);
			gp.setHgap(10);
			gp.setVgap(10);
			
			bp5.setCenter(gp);
			
			Button b1=new Button("Add To cart");
			b1.setOnAction(e -> {
				for(int k=0;k<a.customers.size();k++) {
					if(a.customers.get(k).getId()==Double.parseDouble(t.getText().trim())) {
						for(int j=0;j<a.medies.size();j++) {
							if(a.medies.get(j).getCode().equals(t3.getText().trim())) {
								a.addToCart(a.customers.get(k).getName(),a.medies.get(j).getTitle());
							}
					}
				 }
				}
			});
			Button b2=new Button("Process Cart");
			b2.setOnAction(e -> {
				System.out.println(a.processRequests());
				t.clear();
				t2.clear();
				t3.clear();
				t4.clear();
				t5.clear();
			});
			Button b3=new Button("Back");
			b3.setOnAction(d -> {
				stage.setScene(scene1);
				stage.show();
			});
			
			HBox h7=new HBox();
			h7.getChildren().addAll(b1,b2);
			h7.setSpacing(15);
			h7.setAlignment(Pos.CENTER_LEFT);
			
			HBox h8=new HBox();
			h8.getChildren().addAll(h7,b3);
			h8.setSpacing(80);
			
			bp5.setBottom(h8);
			
			Scene scene26=new Scene(bp5,400,420);
			stage.setScene(scene26);
			stage.show();
			
		});

		
		 stage.setScene(scene1);
		 stage.setTitle("Project");
		 stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void read(MediaRentalManger a) throws FileNotFoundException {
		File cus=new File("customer.txt");
		if(cus.exists()) {
			Scanner in =new Scanner(cus);
			while(in.hasNext()) {
				String[] tokens=in.nextLine().trim().split(",");
				for(int i=0;i<tokens.length;i++) {
					tokens[i].trim();
				}
				a.addCustomer(Double.parseDouble(tokens[0]),tokens[1], tokens[2],Double.parseDouble(tokens[3]),tokens[4]);
			}
			in.close();
		}
		
	}
	
	public void remove(String filepath,String removeTerm,int positionOfTerm,String delemeter) {
		String tempFile="temp.txt";
		File oldFile=new File(filepath);
		File newFile=new File(tempFile);
		String currentLine;
		String data[];
		
		try {
			FileWriter fw=new FileWriter(tempFile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			
			FileReader fr=new FileReader(filepath);
			BufferedReader br=new BufferedReader(fr);
			
			while((currentLine = br.readLine()) != null) {
				data = currentLine.split(",");
				if(!(data[positionOfTerm].equalsIgnoreCase(removeTerm))) {
					pw.println(currentLine);
				}
			}
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			
			oldFile.delete();
			File dump= new File(filepath);
			newFile.renameTo(dump);
		}
		catch(Exception  e) {
			System.out.println("Error!!");
		}
	}
	
	public void ubdate(String filepath,String editTerm,String newID,String newName,String newAdress,String newMobile) throws IOException {
		String tempFile="temp.txt";
		File oldFile=new File(filepath);
		File newFile=new File(tempFile);

			FileWriter fw=new FileWriter(tempFile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			Scanner in=new Scanner(new File(filepath));
			while(in.hasNext()) {
				String[] tkz=in.nextLine().trim().split(",");
				for(int i=0;i<tkz.length;i++)
					tkz[i].trim();
				
				if(tkz[0].equals(editTerm)) {
					pw.println(newID+","+newName+","+newAdress+","+newMobile+","+tkz[4]+",");
				}
				else {
					pw.println(tkz[0]+","+tkz[1]+","+tkz[2]+","+tkz[3]+","+tkz[4]+",");
				}
			}
			in.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump=new File(filepath);
			newFile.renameTo(dump);
	}
	public void reada(MediaRentalManger a) throws FileNotFoundException {
		File alb=new File("album.txt");
		if(alb.exists()) {
			Scanner in =new Scanner(alb);
			while(in.hasNext()) {
				String[] tokens=in.nextLine().trim().split(",");
				for(int i=0;i<tokens.length;i++) {
					tokens[i].trim();
				}
				a.addAlbum(tokens[0],tokens[1],Integer.parseInt(tokens[2]), tokens[3],tokens[4]);
			}
			in.close();
		}
		
	}
	public void readg(MediaRentalManger a) throws FileNotFoundException {
		File alb=new File("game.txt");
		if(alb.exists()) {
			Scanner in =new Scanner(alb);
			while(in.hasNext()) {
				String[] tokens=in.nextLine().trim().split(",");
				for(int i=0;i<tokens.length;i++) {
					tokens[i].trim();
				}
				a.addGame(tokens[0],tokens[1],Integer.parseInt(tokens[2]),Double.parseDouble(tokens[3]));
			}
			in.close();
		}
		
	}
	public void readm(MediaRentalManger a) throws FileNotFoundException {
		File alb=new File("movie.txt");
		if(alb.exists()) {
			Scanner in =new Scanner(alb);
			while(in.hasNext()) {
				String[] tokens=in.nextLine().trim().split(",");
				for(int i=0;i<tokens.length;i++) {
					tokens[i].trim();
				}
				a.addMovie(tokens[0],tokens[1],Integer.parseInt(tokens[2]),tokens[3]);
			}
			in.close();
		}
		
	}
	public void ubdatem(String filepath,String editTerm,String newCode,String newTitle,int noc,String newRating) throws IOException {
		String tempFile="temp.txt";
		File oldFile=new File(filepath);
		File newFile=new File(tempFile);

			FileWriter fw=new FileWriter(tempFile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			Scanner in=new Scanner(new File(filepath));
			while(in.hasNext()) {
				String[] tkz=in.nextLine().trim().split(",");
				for(int i=0;i<tkz.length;i++)
					tkz[i].trim();
				
				if(tkz[0].equals(editTerm)) {
					pw.println(newCode+","+newTitle+","+noc+","+newRating+",");
				}
				else {
					pw.println(tkz[0]+","+tkz[1]+","+tkz[2]+","+tkz[3]+",");
				}
			}
			in.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump=new File(filepath);
			newFile.renameTo(dump);
	}
	public void ubdateg(String filepath,String editTerm,String newCode,String newTitle,int noc,double newWeight) throws IOException {
		String tempFile="temp.txt";
		File oldFile=new File(filepath);
		File newFile=new File(tempFile);

			FileWriter fw=new FileWriter(tempFile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			Scanner in=new Scanner(new File(filepath));
			while(in.hasNext()) {
				String[] tkz=in.nextLine().trim().split(",");
				for(int i=0;i<tkz.length;i++)
					tkz[i].trim();
				
				if(tkz[0].equals(editTerm)) {
					pw.println(newCode+","+newTitle+","+noc+","+newWeight+",");
				}
				else {
					pw.println(tkz[0]+","+tkz[1]+","+tkz[2]+","+tkz[3]+",");
				}
			}
			in.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump=new File(filepath);
			newFile.renameTo(dump);
	}
	public void ubdatea(String filepath,String editTerm,String newCode,String newTitle,int noc,String newArtist,String newSong) throws IOException {
		String tempFile="temp.txt";
		File oldFile=new File(filepath);
		File newFile=new File(tempFile);

			FileWriter fw=new FileWriter(tempFile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			Scanner in=new Scanner(new File(filepath));
			while(in.hasNext()) {
				String[] tkz=in.nextLine().trim().split(",");
				for(int i=0;i<tkz.length;i++)
					tkz[i].trim();
				
				if(tkz[0].equals(editTerm)) {
					pw.println(newCode+","+newTitle+","+noc+","+newArtist+","+newSong+",");
				}
				else {
					pw.println(tkz[0]+","+tkz[1]+","+tkz[2]+","+tkz[3]+","+tkz[4]+",");
				}
			}
			in.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump=new File(filepath);
			newFile.renameTo(dump);
	}
}