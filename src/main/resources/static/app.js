const fixedContainer = document.getElementById('fixed-container');
const customContainer = document.getElementById('custom-container');
const input = document.getElementById('custom-input');

async function loadFixedExts() {
    const res = await fetch('/api/ext/fixed-exts');
    const data = await res.json();
    fixedContainer.innerHTML = '';

    data.forEach(ext => {
        const checkbox = document.createElement('input');
        checkbox.type = 'checkbox';
        checkbox.checked = ext.checked;
        checkbox.onchange = () => updateFixed(ext.ext, checkbox.checked);

        const label = document.createElement('label');
        label.textContent = ext.ext;
        label.appendChild(checkbox);
        fixedContainer.appendChild(label);
        fixedContainer.appendChild(document.createElement('br'));
    });
}

async function updateFixed(ext, checked) {
    const res = await fetch('/api/ext/fixed-exts', {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify([{ ext, checked }])
    });
}

async function loadCustomExts() {
    const res = await fetch('/api/ext/custom-exts');
    const data = await res.json();
    customContainer.innerHTML = '';

    data.forEach(ext => {
        const tag = document.createElement('span');
        tag.textContent = ext.ext;
        const x = document.createElement('button');
        x.textContent = 'X';
        x.onclick = () => deleteCustom(ext.ext);
        tag.appendChild(x);
        customContainer.appendChild(tag);
        customContainer.appendChild(document.createElement('br'));
    });
}

async function addCustom() {
    const ext = input.value.trim();
    if (!ext || ext.length > 20) {
        alert('1~20자의 확장자만 입력 가능');
        return;
    }

    const res = await fetch('/api/ext/custom-exts?ext=' + ext, { method: 'POST' });
    if (res.ok) {
        input.value = '';
        loadCustomExts();
    } else {
        alert('중복 또는 오류');
    }
}

async function deleteCustom(ext) {
    await fetch('/api/ext/custom-exts?ext=' + ext, { method: 'DELETE' });
    loadCustomExts();
}

loadFixedExts();
loadCustomExts();
