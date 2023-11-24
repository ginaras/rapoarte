package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDTableAttributeObject;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        new tabel();
//        linii();
    }

    private static void linii() throws IOException {
        LocalDateTime date1 = LocalDateTime.now();
        DateTimeFormatter date01 = DateTimeFormatter.ofPattern("yyyy-MM-dd '-' HH.mm");
        DateTimeFormatter date02 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String replaceNumeData1 = date1.format( date01 );

        PDDocument document=new PDDocument();
        document.addPage( new PDPage() );

        PDDocumentInformation pdd=document.getDocumentInformation();
        pdd.setAuthor("Autor");
        pdd.setTitle("Title");
        pdd.setCreator("creator");
        pdd.setSubject("Subject");

        Calendar date=new GregorianCalendar();
        date.set(2022,7,2);
        PDPage page=document.getPage(0);

        PDPageContentStream contentStream=new PDPageContentStream(document,page);
        contentStream.beginText();
//        Setting the position for the line
        contentStream.newLineAtOffset(100, 700);
        contentStream.setLeading(14.5f);
//        contentStream.newLineAtOffset(100,725);- disparre scrisul
//        //Setting the font to the Content stream
        contentStream.setFont(PDType1Font.COURIER,12);
////        contentStream.setFont(PDType1Font.HELVETICA,14);
//
//


        String text = "This is the sample document and we are adding content to it.";
        String text2="text 2 added in pdf";

        PDTableAttributeObject table=new PDTableAttributeObject();

//        Adding text in the form of string
        contentStream.showText(text);
        contentStream.newLine();
        contentStream.showText(text2);
        contentStream.newLine();
        contentStream.showText("line 3");
        contentStream.newLine();


        contentStream.endText();
        contentStream.close();
//        document.save(pathSitutiaSoldurilorStage5 + replaceNumeData1 + "'.pdf");
        document.save("d:\\Users\\sorin.ginara\\Desktop\\program" + replaceNumeData1 + "'.pdf");

        document.close();

        Desktop.getDesktop().open(new File("d:\\Users\\sorin.ginara\\Desktop\\program" + replaceNumeData1 + "'.pdf"));
    }

    public static class tabel {

//        LocalDate dataRaportului = dataSold.getValue();
        LocalDateTime date1 = LocalDateTime.now();
        DateTimeFormatter date01 = DateTimeFormatter.ofPattern("yyyy-MM-dd '-' HH.mm");
        DateTimeFormatter date02 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String replaceNumeData1 = date1.format( date01 );

        PDDocument document;
        PDPageContentStream contentStream;
        private int[] colWidths;
        private int cellHeight;
        private int yPosition;
        private int xPosition;
        private int colPosition=0;
        private int intxInitialPosition;
        private float fontSize;
        private PDFont font;
        private Color fontColor;

        public void myTableClass(PDDocument document, PDPageContentStream contentStream) {

            this.document = document;
            this.contentStream = contentStream;
        }
            void setTable(int[] colWidths, int cellHeight,int xPosition, int yPosition){

            this.colWidths=colWidths;
            this.cellHeight=cellHeight;
            this.xPosition=xPosition;
            this.yPosition=yPosition;
            intxInitialPosition=xPosition;
        }
        void setTableFont (PDFont font, float fontSize, Color fontColor)
        {
            this.font=font;
            this.fontSize=fontSize;
            this.fontColor=fontColor;
        }
        void addCell(String text, Color filltColor) throws IOException
        {
            contentStream.setStrokingColor(1f);

            if (filltColor!=null ){
                contentStream.setNonStrokingColor(1f);
            }
            contentStream.addRect(xPosition,yPosition,colWidths[colPosition], cellHeight);

            if (filltColor==null)
                contentStream.stroke();
            else contentStream.fillAndStroke();

            contentStream.beginText();
            contentStream.setNonStrokingColor(fontColor);
            if(colPosition==4 || colPosition ==2){
                float fontWidth=font.getStringWidth(text)/1000*fontSize;
                contentStream.newLineAtOffset(xPosition+colWidths[colPosition]-20-fontWidth, yPosition+10);
            }
            else {
                contentStream.newLineAtOffset(xPosition-20, yPosition+10);
            }
            contentStream.showText(text);
            contentStream.endText();

            xPosition =xPosition+colWidths[colPosition];
            colPosition++;

            if (colPosition==colWidths.length) {
                colPosition=0;
                xPosition=intxInitialPosition;
                yPosition=cellHeight;
            }
        }

//        document.addPage( new PDPage() );
//
//
//        PDPage page=document.getPage(0);
//
//        PDPageContentStream contentStream=new PDPageContentStream(document,page);
//        contentStream.beginText();
////        Setting the position for the line
//        contentStream.newLineAtOffset(100, 700);
//        contentStream.setLeading(14.5f);
//
//        contentStream.setFont(PDType1Font.COURIER,12);
//////        contentStream.setFont(PDType1Font.HELVETICA,14);
////
////
//        int pageWidth = (int)page.getTrimBox().getWidth(); //get width of the page
//        int pageHeight = (int)page.getTrimBox().getHeight(); //get height of the page
//
//        contentStream.setStrokingColor(Color.DARK_GRAY);
//
//        contentStream.setLineWidth(1);
////
//        int initX = 50;
//        int initY = pageHeight-50;
//        int cellHeight = 20;
//        int cellWidth = 100;
//
//        int colCount = 3;
//        int rowCount = 3;
////
//        for(int i = 1; i<=rowCount;i++){
//            for(int j = 1; j<=colCount;j++){
////                if(j = 1){
////                    contentStream.addRect(initX,initY,cellWidth+30,-cellHeight);
//                    contentStream.addComment("hfşadjdşjsc");
//
////                    contentStream.beginText();
////                    contentStream.newLineAtOffset(initX+30,initY-cellHeight+10);
////                    contentStream.setFont(PDType1Font.TIMES_ROMAN,10);
////                    contentStream.showText("Dinuka");
////                    contentStream.endText();
//
//                    initX+=cellWidth;
//                    initY-=cellHeight;
////                }else{
////                    contentStream.addRect(initX,initY,cellWidth,-cellHeight);
////
//////                    contentStream.beginText();
//////                    contentStream.newLineAtOffset(initX+10,initY-cellHeight+10);
//////                    contentStream.setFont(PDType1Font.TIMES_ROMAN,10);
//////                    contentStream.showText("Dinuka");
//////                    contentStream.endText();
////
////                    initX+=cellWidth;
////                    initY-=cellHeight;
////
////                }
//            }
//            initX = 50;
//            initY -=cellHeight;
//        }
////
////        contentStream.stroke();
//
//        contentStream.endText();
//        contentStream.close();
////        document.save(pathSitutiaSoldurilorStage5 + replaceNumeData1 + "'.pdf");
//        document.save("d:\\Users\\sorin.ginara\\Desktop\\program" + replaceNumeData1 + "'.pdf");
//
//        document.close();
//
//        Desktop.getDesktop().open(new File("d:\\Users\\sorin.ginara\\Desktop\\program" + replaceNumeData1 + "'.pdf"));
    }
}