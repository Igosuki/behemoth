package fr.xebia.behemoth

class AppTagLib {
    static namespace = 'app'

    def textFieldRow = { attrs ->
        String labelCodeDefault = attrs.remove('labelCodeDefault')
        String name = getRequiredAttribute(attrs, 'name', 'textFieldRow')
        String labelCode = getRequiredAttribute(attrs, 'labelCode', 'textFieldRow')
        def value = getRequiredAttribute(attrs, 'value', 'textFieldRow')
        def bean = getRequiredAttribute(attrs, 'bean', 'textFieldRow')

        def fieldAttributes = [name: name, value: value] + attrs
        out << """
		<tr class="prop">
			<td valign="top" class="name">
			<label for="${name}">${message(code: labelCode, default: labelCodeDefault)}</label>
			</td>
			<td valign="top" class="value ${hasErrors(bean: bean, field: name, 'errors')}">
			${textField(fieldAttributes)}
			${fieldErrors(bean: bean, field: name)}
			</td>
		</tr>
		"""
    }

    def passwordFieldRow = { attrs ->
        String labelCodeDefault = attrs.remove('labelCodeDefault')
        String name = getRequiredAttribute(attrs, 'name', 'passwordFieldRow')
        String labelCode = getRequiredAttribute(attrs, 'labelCode', 'passwordFieldRow')
        def value = getRequiredAttribute(attrs, 'value', 'passwordFieldRow')
        def bean = getRequiredAttribute(attrs, 'bean', 'passwordFieldRow')

        def fieldAttributes = [name: name, value: value] + attrs
        out << """
		<tr class="prop">
			<td valign="top" class="name">
			<label for="${name}">${message(code: labelCode, default: labelCodeDefault)}</label>
			</td>
			<td valign="top" class="value ${hasErrors(bean: bean, field: name, 'errors')}">
			${passwordField(fieldAttributes)}
			${fieldErrors(bean: bean, field: name)}
			</td>
		</tr>
		"""
    }

    def fieldErrors = { attrs ->
        def bean = attrs.remove('bean')
        if (bean) {
            out << eachError(attrs, {
                out << "<span class='s2ui_error'>${message(error:it)}</span>"
            })
        }
    }

    protected void writeDocumentReady(writer, String javascript) {
        writer << """
		<script>
		\$(document).ready(function() {
			${javascript}
		});
		</script>
		"""
    }

    protected String resolveText(attrs) {
        String messageCode = attrs.remove('messageCode')
        if (messageCode) {
            return message(code: messageCode)
        }

        return attrs.remove('text')
    }

    protected getRequiredAttribute(attrs, String name, String tagName) {
        if (!attrs.containsKey(name)) {
            throwTagError("Tag [$tagName] is missing required attribute [$name]")
        }
        attrs.remove name
    }

    protected void writeRemainingAttributes(writer, attrs) {
        writer << attrs.collect { k, v -> """ $k="$v" """ }.join('')
    }

}
