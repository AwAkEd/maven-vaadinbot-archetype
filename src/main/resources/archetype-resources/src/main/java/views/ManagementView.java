package ${package}.views;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.Reindeer;

import ${package}.utils.Messages;

@SuppressWarnings("serial")
public class ManagementView<T> extends CustomComponent {

    public enum ActionButtons {
	OK, CANCEL;
    }
    
    private VerticalLayout componentLayout = new VerticalLayout();
    
    private VerticalSplitPanel content = new VerticalSplitPanel();

    private Layout form;
    
    private HorizontalLayout footer;

    private T bean;

    private BeanItem<T> beanItem;

    private BeanFieldGroup<T> fieldGroup;

    private BeanItemContainer<T> container;

    private Table table;

    public ManagementView(Class<T> clazz) throws Exception {
    	setSizeFull();
    	this.componentLayout.setSizeFull();
    	this.componentLayout.setMargin(false);
    	this.componentLayout.setSpacing(false);
    	this.content.setSplitPosition(50, Unit.PERCENTAGE);
    	this.content.setLocked(true);
    	this.content.setStyleName(Reindeer.SPLITPANEL_SMALL);
    	this.bean = clazz.newInstance();
    	this.beanItem = new BeanItem<T>(this.bean);
    	this.fieldGroup = new BeanFieldGroup<T>(clazz);
    	this.fieldGroup.setBuffered(false);
    	this.container = new BeanItemContainer<T>(clazz);
    	this.table = new Table();
    	this.table.setContainerDataSource(container);
    	this.table.setSelectable(true);
    	this.table.setImmediate(true);
    	this.table.setHeight(100, Unit.PERCENTAGE);
    	this.table.setWidth(90, Unit.PERCENTAGE);
    	this.form = new FormLayout();
    	this.footer = new HorizontalLayout();
    	this.footer.setSizeUndefined();
    	this.content.addComponents(this.table, this.form);
    	this.componentLayout.addComponent(this.content);
    	setCompositionRoot(this.componentLayout);
    }

    public ManagementView(Class<T> clazz, String caption) throws Exception {
    	this(clazz);
    	this.table.setCaption(caption);
    }

    public void visibleFormFields(Object[] fields) {
    	for (Object propertyId : fields) {
    	    this.form.addComponent(this.fieldGroup.buildAndBind(propertyId));
    	}
    	this.form.addComponent(this.footer);
    }
    
    public void requiredFields(Object[] fields) {
    	for (Object propertyId : fields) {
    	    this.fieldGroup.getField(propertyId).setRequired(true);
    	}
    }

    public void autogenerateFormFields() {
    	for (Object propertyId : beanItem.getItemPropertyIds()) {
    	    this.form.addComponent(this.fieldGroup.buildAndBind(propertyId));
    	}
    	this.form.addComponent(this.footer);
    }

    public void setTableColumns(Object[] cols, String[] i18n) {
    	this.table.setVisibleColumns(cols);
    	this.table.setColumnHeaders(i18n);
    }

    public void refreshTableData() {
        this.table.removeAllItems();
    }
    
    public void rebind(T bean) {
    	getFieldGroup().setItemDataSource(bean);
    	for (Field<?> f : getFieldGroup().getFields()) {
    	    if (f instanceof TextField) {
    	        ((TextField) f).setNullRepresentation("");
    	    } else if (f instanceof TextArea) {
    	        ((TextArea) f).setNullRepresentation("");
    	    } if (f instanceof PasswordField) {
    	        ((PasswordField) f).setNullRepresentation("");
    	    } if (f instanceof ComboBox) {
    	        ((ComboBox) f).setNullSelectionItemId("");
    	    }
    	}
    }

    public T getBean() {
        return this.bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

    public BeanItem<T> getBeanItem() {
        return this.beanItem;
    }

    public void setBeanItem(BeanItem<T> beanItem) {
        this.beanItem = beanItem;
    }

    public BeanFieldGroup<T> getFieldGroup() {
        return this.fieldGroup;
    }

    public void setFieldGroup(BeanFieldGroup<T> fieldGroup) {
        this.fieldGroup = fieldGroup;
    }

    public BeanItemContainer<T> getContainer() {
        return this.container;
    }

    public void setContainer(BeanItemContainer<T> container) {
        this.container = container;
    }

    public Layout getForm() {
        return this.form;
    }

    public void setForm(Layout form) {
        this.form = form;
    }

    public HorizontalLayout getFooter() {
        return this.footer;
    }

    public void setFooter(HorizontalLayout footer) {
        this.footer = footer;
    }

    public Table getTable() {
        return this.table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

}
